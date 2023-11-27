package window.scenes;

import player.Fighter;
import player.FighterConstants;
import player.Ryu;
import util.HurtBox;
import util.io.KL;
import window.Window;
import window.WindowConstants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene extends Scene{


    private int _frameRate = 0;
    private String _displayInfo = "";

//    private Fighter _fighter1 = new Fighter((int) FighterConstants.PLAYER1_START_X, (int) FighterConstants.PLAYER_START_Y);
//    private Fighter _fighter2 = new Fighter((int) FighterConstants.PLAYER2_START_X, (int) FighterConstants.PLAYER_START_Y);

//    private HurtBox hurtTest = new HurtBox((int) FighterConstants.PLAYER2_START_X, (int) FighterConstants.PLAYER_START_Y-300, 200, 400);
//    private HurtBox hurtTest = new HurtBox((int) 0, (int) 0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);

    Fighter ryu = new Ryu((int) FighterConstants.PLAYER1_START_X, (int) FighterConstants.PLAYER_START_Y-100, 80, 80);
    Fighter ryu2 = new Ryu((int) FighterConstants.PLAYER1_START_X+250, (int) FighterConstants.PLAYER_START_Y-100, 80, 80);

    @Override
    public void update(double deltaTime) {
        _frameRate = (int) (1/deltaTime);
        _displayInfo = String.format("%d FPS (%.3f)", _frameRate,deltaTime);

        ryu.update(deltaTime);
        ryu2.update(deltaTime);
//        _fighter1.update(deltaTime);
//        _fighter2.update(deltaTime);

        if(ryu.isAttacking && ryu.animator.getCurrentHitBox() != null) {
            if(ryu.animator.getCurrentHitBox().overlaps(ryu2.animator.getCurrentHurtBox())) {
                System.out.println("HIT!");
            }
        }

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



//        hurtTest.draw(g);
//        _fighter1.draw(g);
        ryu.draw(g);
        ryu2.draw(g);
    }
}
