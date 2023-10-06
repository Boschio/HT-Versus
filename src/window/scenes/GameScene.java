package window.scenes;

import player.Player;
import player.PlayerConstants;
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
    private Player _player1 = new Player((int)PlayerConstants.PLAYER1_START_X, (int)PlayerConstants.PLAYER_START_Y);
    private Player _player2 = new Player((int)PlayerConstants.PLAYER2_START_X, (int)PlayerConstants.PLAYER_START_Y);

    private HurtBox hurtTest = new HurtBox((int)PlayerConstants.PLAYER2_START_X, (int)PlayerConstants.PLAYER_START_Y, 200, 200);

    @Override
    public void update(double deltaTime) {
        _frameRate = (int) (1/deltaTime);
        _displayInfo = String.format("%d FPS (%.3f)", _frameRate,deltaTime);

        _player1.update(_player1, deltaTime);
        _player2.update(_player2, deltaTime);

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE)){
            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
        }

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);
        g.setColor(Color.GREEN);
        g.drawString(_displayInfo,10, (int) (WindowConstants.INSET_SIZE*1.5));

        hurtTest.draw(g);
        _player1.draw(g);
        if (_player1.isAttacking) {
            HitBox h = new HitBox((int) (_player1.x + PlayerConstants.PLAYER_WIDTH),(int) _player1.y + 50,150,70);
            h.draw(g);
            if (h.overlaps(hurtTest)) {
                System.out.println("HIT!");
                hurtTest.setColor(Color.YELLOW);
            }
            _player1.isAttacking = false;
        }
        _player2.draw(g);
        if (_player2.isAttacking) {
            HitBox h = new HitBox((int) (_player2.x + PlayerConstants.PLAYER_WIDTH),(int) _player2.y + 50,150,70);
            h.draw(g);
            _player2.isAttacking = false;
        }
    }
}
