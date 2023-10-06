package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class IdleState implements State {
    private KL keyListener = KL.getKeyListener();

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public State input(KL e) {
        if (e.isKeyDown(KeyEvent.VK_A) || e.isKeyDown(KeyEvent.VK_D)) {
            return new MoveState();
        }
        return null;
    }

    @Override
    public State update(Player player, double deltaTime) {
        if (keyListener.isKeyDown(KeyEvent.VK_A) || keyListener.isKeyDown(KeyEvent.VK_D)) {
            return new MoveState();
        }
        if(player.keyListener.isKeyDown(KeyEvent.VK_W)){
            return new JumpState();
        }
        return new IdleState();
    }
}
