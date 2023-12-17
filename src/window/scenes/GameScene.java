package window.scenes;

import player.FighterConstants;
import player.Player;

import util.Time;
import util.io.KL;
import window.WindowConstants;
import window.stage.Camera;
import window.stage.Stage;
import window.ui.pauseScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene extends Scene{

    private int _frameRate = 0;
    private String _displayInfo = "";

    private pauseScreen pauseScreen = new pauseScreen();
    private boolean isPaused = false;

    Stage stage;
    Player p1;
    Player p2;

    Camera camera;

    public GameScene() {
        stage = new Stage("akuma");

        p1 = new Player(1, FighterConstants.Characters.Ryu);
        p2 = new Player(2, FighterConstants.Characters.Ryu);

        this.camera = new Camera(p1,p2,stage);
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
            if(p1.getHitBox().overlaps(p2.getHurtBox())) {
                System.out.println("P2 HIT!");
                p2.takeDamage(10);
            }
        }
        if(p2.isAttacking && p2.animator.getCurrentHitBox() != null) {
            if(p2.getHitBox().overlaps(p1.getHurtBox())) {
                System.out.println("P1 HIT!");
                p1.takeDamage(10);
            }
        }

        if (p2.isToBeDestroyed()) {
//            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
        }
    }

    @Override
    public void update(double deltaTime) {
        _frameRate = (int) (1/deltaTime);
        _displayInfo = String.format("%d FPS (%.3f)", _frameRate,deltaTime);

        if (isPaused) {

        } else {
            debugGameSpeed();

            camera.update(deltaTime);
            playerUpdate(deltaTime);

            hitDetection();

        }

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE)){
//            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
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
        if (isPaused) {
            pauseScreen.draw(g);
        }

        debugInfo(g);
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
