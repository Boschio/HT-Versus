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
    public double x;
    public double y;
    double vx = 0;
    double vy = 0;
    final static double gravity = 0.3;
    double ay = gravity;

    public boolean isAttacking = false;

    /**<p>
     * Saves a pointer to the singleton instance of the KeyListener class
     *</p>
     */
    private KL keyListener = KL.getKeyListener();

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }


    public void draw(Graphics g){

        g.setColor(PlayerConstants.characterColor);
        g.fillRect((int) this.x, (int) this.y, PlayerConstants.PLAYER_WIDTH, PlayerConstants.PLAYER_HEIGHT);

    }


    public void update(double deltaTime){
        move();
        HandleMovement(deltaTime);
        HandleAttack(deltaTime);
    }

    private void handleWalkForward() {

    }

    private void handleWalkBackward() {

    }

    private void HandleMovement(double deltaTime){
        if(keyListener.isKeyDown(KeyEvent.VK_W)){
            jump(1);
        }

        if(keyListener.isKeyDown(KeyEvent.VK_S)){
            // NEED TO ENTER CROUCH STATE
        }

        if(keyListener.isKeyDown(KeyEvent.VK_A)){
            this.x -= 3.0;
        }
        if(keyListener.isKeyDown(KeyEvent.VK_D)){
            this.x += 3.0;
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

    private void jump(double dy) {
        // y = a(x-h)2 + k, where h is the vertex or x^2 = -4ay
        vy -= dy;
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
