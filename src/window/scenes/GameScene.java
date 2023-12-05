package window.scenes;

import player.FighterConstants;
import player.Player;
import util.HitBox;
import util.HurtBox;
import util.Time;
import util.io.KL;
import window.WindowConstants;
import window.ui.pauseScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene extends Scene{


    private int _frameRate = 0;
    private String _displayInfo = "";

    private pauseScreen pauseScreen = new pauseScreen();
    private boolean isPaused = false;

    Player player1 = new Player(1, FighterConstants.Characters.Ryu);
    Player player2 = new Player(2, FighterConstants.Characters.Ryu);

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
    }

    private void playerUpdate(double deltaTime) {
        if (player1.x < player2.x) {
            player1.isFacingLeft = false;
            player2.isFacingLeft = true;
        } else {
            player1.isFacingLeft = true;
            player2.isFacingLeft = false;
        }
        player1.update(deltaTime);
        player2.update(deltaTime);
    }

    private void hitDetection() {
        if(player1.isAttacking && player1.animator.getCurrentHitBox() != null) {
            if(player1.getHitBox().overlaps(player2.getHurtBox())) {
                System.out.println("P2 HIT!");
                player2.takeDamage(10);
            }
        }
        if(player2.isAttacking && player2.animator.getCurrentHitBox() != null) {
            if(player2.getHitBox().overlaps(player1.getHurtBox())) {
                System.out.println("P1 HIT!");
                player1.takeDamage(10);
            }
        }

        if (player2.isToBeDestroyed()) {
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
        g.setColor(Color.RED);
        g.drawString(_displayInfo,10, (int) (WindowConstants.INSET_SIZE*1.5));

        player1.draw(g);
        player2.draw(g);
        if (isPaused) {
            pauseScreen.draw(g);
        }

        debugInfo(g);
    }

    public void debugInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font myFont = new Font ("Courier New", 1, 17);
        g.setFont(myFont);

        g.drawString(String.format("player1 hitbox tip position: %2f", player1.animator.getCurrentHitBox() != null ? player1.getHitBox().x + player1.getHitBox().h : -999),WindowConstants.SCREEN_WIDTH-1000, (int) (WindowConstants.INSET_SIZE*1.5));
        g.drawString(String.format("player2 hurtbox back position: %2f", player2.animator.getCurrentHurtBox() != null ? player2.getHurtBox().x + player2.getHurtBox().w : -999),WindowConstants.SCREEN_WIDTH-500, (int) (WindowConstants.INSET_SIZE*1.5));

    }
}
