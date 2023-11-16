package player.states;

import player.Fighter;
import util.io.KL;

import java.awt.event.KeyEvent;

public class WalkForwardState extends State {
    public WalkForwardState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.pose = fighter.WALKFORWARD;
        fighter.animator.changeAnimationTo(fighter.pose);

        fighter.isMoving = true;

        fighter.vx = 450;
//        fighter.x += 3.0;
    }

    public State input(KL keyListener) {
        return null;
    }

    public State update(double deltaTime) {
        fighter.x += fighter.vx * deltaTime;

        if (!fighter.keyListener.isKeyDown(KeyEvent.VK_D)) {
//            return new IdleState();
            return fighter.idleState;
        }
        if (fighter.keyListener.isKeyDown(KeyEvent.VK_A)) {
//            return new WalkBackwardState();
            return fighter.walkBackwardState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_J)) {
//            return new LightAttackState();
            return fighter.lightAttackState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_K)) {
//            return new MediumAttackState();
            return fighter.mediumAttackState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_L)) {
//            return new HeavyAttackState();
            return fighter.heavyAttackState;
        }
        return null;
    }
}
