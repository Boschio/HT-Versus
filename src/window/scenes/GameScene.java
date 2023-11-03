package window.scenes;

import player.Fighter;
import player.FighterConstants;
import player.Ryu;
import util.HitBox;
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

    private HurtBox hurtTest = new HurtBox((int) FighterConstants.PLAYER2_START_X, (int) FighterConstants.PLAYER_START_Y, 200, 200);

    Fighter ryu = new Ryu((int) FighterConstants.PLAYER1_START_X, (int) FighterConstants.PLAYER_START_Y, 80, 80);

    @Override
    public void update(double deltaTime) {
        _frameRate = (int) (1/deltaTime);
        _displayInfo = String.format("%d FPS (%.3f)", _frameRate,deltaTime);

        ryu.update(ryu, deltaTime);
//        _fighter1.update(_fighter1, deltaTime);
//        _fighter2.update(_fighter2, deltaTime);

        if(ryu.isAttacking) {
            if(ryu.hitbox != null && ryu.hitbox.overlaps(hurtTest)) {
                System.out.println("HIT!");
            }
        }


        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE)){
            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
        }
        try
        {
            Thread.sleep(15);
        }
        catch(Exception x) {}

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);
        g.setColor(Color.RED);
        g.drawString(_displayInfo,10, (int) (WindowConstants.INSET_SIZE*1.5));



        hurtTest.draw(g);
//        _fighter1.draw(g);
        ryu.draw(g);
//        if (ryu.isAttacking) {
//            HitBox h = new HitBox((int) (ryu.x + FighterConstants.PLAYER_WIDTH),(int) ryu.y + 50,150,70);
//            h.draw(g);
//            if (h.overlaps(hurtTest)) {
//                System.out.println("HIT!");
//                hurtTest.setColor(Color.YELLOW);
//            }
//            ryu.isAttacking = false;
//        }

//        if (_fighter1.isAttacking) {
//            HitBox h = new HitBox((int) (_fighter1.x + FighterConstants.PLAYER_WIDTH),(int) _fighter1.y + 50,150,70);
//            h.draw(g);
//            if (h.overlaps(hurtTest)) {
//                System.out.println("HIT!");
//                hurtTest.setColor(Color.YELLOW);
//            }
//            _fighter1.isAttacking = false;
//        }
//        _fighter2.draw(g);
//        if (_fighter2.isAttacking) {
//            HitBox h = new HitBox((int) (_fighter2.x + FighterConstants.PLAYER_WIDTH),(int) _fighter2.y + 50,150,70);
//            h.draw(g);
//            _fighter2.isAttacking = false;
//        }
    }
}
