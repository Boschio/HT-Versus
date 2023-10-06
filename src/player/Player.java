package player;

import static player.PlayerState.*;

import util.HitBox;
import util.HurtBox;
import util.Rect;
import util.io.KL;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {



    PlayerState playerState;
    State activeState = new IdleState();
    public double x;
    public double y;
    double vx = 0;
    double vy = 0;
    int jumpHeight = 10;
    final static double gravity = 0.1;
    double ay = gravity;

    public boolean isAttacking = false;

    public KL keyListener = KL.getKeyListener();

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }


    public void draw(Graphics g){

        g.setColor(PlayerConstants.characterColor);
        g.fillRect((int) this.x, (int) this.y, (int)PlayerConstants.PLAYER_WIDTH, (int)PlayerConstants.PLAYER_HEIGHT);

    }

    void changeState(State newState) {
        activeState.exit();
        // Do I need to clear old state from mem?
        activeState = newState;
        activeState.enter(this);
    }

    void input(KL keyListener) {
        State newState = activeState.input(keyListener);
        if (newState != null) {
            changeState(newState);
        }
    }

    public void update(Player player, double deltaTime){
        State newState = activeState.update(this, deltaTime);
        if (newState != null) {
            changeState(newState);
        }
//        System.out.println("Current State: " + activeState.toString());
    }

}
