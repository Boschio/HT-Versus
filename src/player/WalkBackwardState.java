package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class WalkBackwardState implements State {
    @Override
    public void enter(Fighter fighter) {
        fighter.pose = fighter.WALKBACKWARD;
        fighter.animator.changeAnimationTo(fighter.pose);

        fighter.isMoving = true;

        fighter.vx = -450;
//        fighter.x -= 3.0;
    }

    @Override
    public State input(KL keyListener) {
        return null;
    }

    @Override
    public State update(Fighter fighter, double deltaTime) {
        fighter.x += fighter.vx * deltaTime;

        if (!fighter.keyListener.isKeyDown(KeyEvent.VK_A)) {
            return new IdleState();
        }
        if (fighter.keyListener.isKeyDown(KeyEvent.VK_D)) {
            return new WalkForwardState();
        }
        return null;
    }
}
