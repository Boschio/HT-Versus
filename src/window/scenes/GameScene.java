package window.scenes;

import player.FighterConstants;
import player.Player;

import util.Time;
import util.io.KL;
import window.Window;
import window.WindowConstants;
import window.stage.Camera;
import window.stage.Stage;
import window.ui.UI;
import window.ui.PauseScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene extends Scene{

    private int _frameRate = 0;
    private String _displayInfo = "";

    private PauseScreen pauseScreen;

    public static double pauseCooldown = 0.0;
    public boolean isPaused, p1Win, p2Win;

    Stage stage;
    public Player p1;
    public Player p2;

    Camera camera;
    UI ui;

    public GameScene() {
        stage = new Stage("akuma");

        p1 = new Player(1, FighterConstants.Characters.Ryu);
        p2 = new Player(2, FighterConstants.Characters.Ryu);

        this.camera = new Camera(p1,p2,stage);
        this.ui = new UI(this);
        this.pauseScreen = new PauseScreen(this);
        this.isPaused = false;
        this.p1Win = false;
        this.p2Win = false;
    }

    private static void debugGameSpeed() {
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_1)) {
            Time.setDebugSpeed(60);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_2)) {
            Time.setDebugSpeed(30);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_3)) {
            Time.setDebugSpeed(20);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_4)) {
            Time.setDebugSpeed(5);
        }
    }

    private void playerUpdate(double deltaTime) {
        if (p1.x < p2.x) {
            p1.isFacingLeft = false;
            p2.isFacingLeft = true;
        } else {
            p1.isFacingLeft = true;
            p2.isFacingLeft = false;
        }
        p1.update(deltaTime);
        p2.update(deltaTime);
    }

    private void hitDetection() {
        if(p1.isAttacking && p1.animator.getCurrentHitBox() != null) {
            if(p1.getHitBox().overlaps(p2.getHurtBox()) && p1.attackCooldown <= 0) {
                p1.attackCooldown = .2;
                p2.takeDamage(p1.MoveList.get(p1.currAction).damage[p1.animator.getCurrentFrameIndex()]);
                if (p2.isToBeDestroyed()) {
                    ui.roundOver = true;
                    p1Win = true;
                }
            }
        }
        if(p2.isAttacking && p2.animator.getCurrentHitBox() != null) {
            if(p2.getHitBox().overlaps(p1.getHurtBox()) && p2.attackCooldown <= 0) {
                p2.attackCooldown = .2;
                p1.takeDamage(p2.MoveList.get(p2.currAction).damage[p2.animator.getCurrentFrameIndex()]);
                if (p1.isToBeDestroyed()) {
                    ui.roundOver = true;
                    p2Win = true;
                }
            }
        }
    }

    @Override
    public void update(double deltaTime) {
        _frameRate = (int) (1/deltaTime);
        _displayInfo = String.format("%d FPS (%.3f)", _frameRate,deltaTime);
        pauseScreen.update();
        pauseCooldown -= deltaTime;
        if (isPaused) {

        } else {
            debugGameSpeed();
            ui.update(deltaTime);
            if (!ui.roundOver) {

                camera.update(deltaTime);
                playerUpdate(deltaTime);
                hitDetection();
            }
            if (ui.roundOver && ui.menuCountdown <= 0) {
                Window.getWindow().changeState(WindowConstants.MENU_SCENE);
            }
        }

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE) && pauseCooldown <= 0){
            pauseCooldown = .5;
            isPaused = !isPaused;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);

        stage.draw(g);

        g.setColor(Color.RED);
        g.drawString(_displayInfo,10, (int) (WindowConstants.INSET_SIZE*1.5));

        p1.draw(g);
        p2.draw(g);

        ui.draw(g);
        debugInfo(g);
        if (isPaused) {
            pauseScreen.draw(g);
        }
    }

    public void debugInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font myFont = new Font ("Courier New", 1, 17);
        g.setFont(myFont);

        g.drawString(String.format("player1 x,y: %2f,%2f", p1.x, p1.y),WindowConstants.SCREEN_WIDTH-1000, (int) (WindowConstants.INSET_SIZE*1.5));
        g.drawString(String.format("player2 x,y: %2f,%2f", p2.x, p2.y),WindowConstants.SCREEN_WIDTH-500, (int) (WindowConstants.INSET_SIZE*1.5));
//        g.drawString(String.format("Current Frame,AnimationLength: %d,%d", player1.animator.getCurrentFrameIndex()+1,player1.animator.getCurrentAnimation().getAnimationLength()),WindowConstants.SCREEN_WIDTH-600, (int) (WindowConstants.INSET_SIZE*1.5));

        int insetGap = 18;
        for (int i = 0; i< p1.inputBuffer.buffer.size(); i++) {
            int insetOffset = 18;
            g.drawString(String.format("Buffer: %s", p1.inputBuffer.buffer.get(i)),10, (int) (WindowConstants.INSET_SIZE*1.5)+insetGap);
            insetGap += insetOffset;
        }

    }
}
