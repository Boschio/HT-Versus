package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class IdleState implements State {
    private KL keyListener = KL.getKeyListener();

    @Override
    public void enter(Fighter fighter) {
        fighter.isMoving = false;
        fighter.pose = fighter.IDLE;
        fighter.vx = 0.0;

        fighter.animator.changeAnimationTo(fighter.IDLE);
    }

    @Override
    public State input(KL e) {
//        if (e.isKeyDown(KeyEvent.VK_A) || e.isKeyDown(KeyEvent.VK_D)) {
//            return new MoveState();
//        }
        return null;
    }

    @Override
    public State update(Fighter fighter, double deltaTime) {
        if (keyListener.isKeyDown(KeyEvent.VK_A)) {
            return new WalkBackwardState();
        }
        if (keyListener.isKeyDown(KeyEvent.VK_D)) {
            return new WalkForwardState();
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_W)){
            return new JumpState();
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_W) && fighter.keyListener.isKeyDown(KeyEvent.VK_D)){
            return new JumpForwardState();
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_J)) {
            return new AttackState();
        }
        return null;
    }
}
