package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class MoveState implements State {
    /**<p>
     * Saves a pointer to the singleton instance of the KeyListener class
     *</p>
     */

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public State input(KL e) {
        return null;
    }

    @Override
    public State update(Player player, double deltaTime) {
        HandleMovement(player);
        if (player.x == 0) {
            return new IdleState();
        }
        return new MoveState();
    }

    private void HandleMovement(Player player){
        if(player.keyListener.isKeyDown(KeyEvent.VK_A)){
            player.x -= 3.0;
        }
        if(player.keyListener.isKeyDown(KeyEvent.VK_D)){
            player.x += 3.0;
        }
    }
}
