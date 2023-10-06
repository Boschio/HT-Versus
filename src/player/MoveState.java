package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class MoveState implements State {
    @Override
    public void enter(Player player) {

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
        if (!player.keyListener.isKeyDown(KeyEvent.VK_A) || !player.keyListener.isKeyDown(KeyEvent.VK_D)) {
            return new IdleState();
        }
        return new MoveState();
    }

    private void HandleMovement(Player player){
        if(player.keyListener.isKeyDown(KeyEvent.VK_A)){
            player.x -= 3.0;
        } else if(player.keyListener.isKeyDown(KeyEvent.VK_D)){
            player.x += 3.0;
        }
    }
}
