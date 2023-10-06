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
    final static double gravity = 0.3;
    double ay = gravity;

    public boolean isAttacking = false;

    public KL keyListener = KL.getKeyListener();

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }


    public void draw(Graphics g){

        g.setColor(PlayerConstants.characterColor);
        g.fillRect((int) this.x, (int) this.y, PlayerConstants.PLAYER_WIDTH, PlayerConstants.PLAYER_HEIGHT);

    }

    void changeState(State newState) {
        activeState.exit();
        // Do I need to clear old state from mem?
        activeState = newState;
        activeState.enter();
    }

    void input(KL keyListener) {
        State newState = activeState.input(keyListener);
        if (newState != null) {
            changeState(newState);
        }
    }

    public void update(Player player, double deltaTime){
//        move();
//        HandleMovement(deltaTime);
//        HandleAttack(deltaTime);
        State newState = activeState.update(this, deltaTime);
        if (newState != null) {
            changeState(newState);
        }
    }

    public void move() {
        x += vx;
        y += vy;
        vy += ay;
        if (this.y + PlayerConstants.PLAYER_HEIGHT >= PlayerConstants.FLOOR) {
            pushAbove(PlayerConstants.FLOOR);
            stopFalling();
        }

    }

    public void stopFalling() {
        vy = 0;
    }

    public void pushAbove(double floor) {
        y = floor - PlayerConstants.PLAYER_HEIGHT - 1;
    }



    private void HandleAttack(double deltaTime){
        if(keyListener.isKeyDown(KeyEvent.VK_J)){
            isAttacking = true;
        }

        if(keyListener.isKeyDown(KeyEvent.VK_K)){
            isAttacking = true;
        }

        if(keyListener.isKeyDown(KeyEvent.VK_L)){
            isAttacking = true;
        }
    }

}
