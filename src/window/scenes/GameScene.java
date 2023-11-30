package window.scenes;

import player.Fighter;
import player.FighterConstants;
import player.Ryu;
import util.Time;
import util.io.KL;
import window.Window;
import window.WindowConstants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene extends Scene{


    private int _frameRate = 0;
    private String _displayInfo = "";

    Fighter ryu = new Ryu((int) FighterConstants.PLAYER1_START_X, (int) FighterConstants.PLAYER_START_Y-100, 80, 80);
    Fighter ryu2 = new Ryu((int) FighterConstants.PLAYER1_START_X+250, (int) FighterConstants.PLAYER_START_Y-100, 80, 80);

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
        ryu.update(deltaTime);
        ryu2.update(deltaTime);
    }

    private void hitDetection() {
        if(ryu.isAttacking && ryu.animator.getCurrentHitBox() != null) {
            if(ryu.animator.getCurrentHitBox().overlaps(ryu2.animator.getCurrentHurtBox())) {
                System.out.println("HIT!");
                ryu2.takeDamage(10);
            }
        }

        if (ryu2.isToBeDestroyed()) {
//            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
        }
    }

    @Override
    public void update(double deltaTime) {
        _frameRate = (int) (1/deltaTime);
        _displayInfo = String.format("%d FPS (%.3f)", _frameRate,deltaTime);

        debugGameSpeed();

        playerUpdate(deltaTime);

        hitDetection();

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE)){
            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);
        g.setColor(Color.RED);
        g.drawString(_displayInfo,10, (int) (WindowConstants.INSET_SIZE*1.5));

        ryu.draw(g);
        ryu2.draw(g);
    }
}
