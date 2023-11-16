package player.states;

import player.Fighter;
import util.io.KL;

import java.awt.event.KeyEvent;

public class WalkBackwardState extends State {
    public WalkBackwardState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.pose = fighter.WALKBACKWARD;
        fighter.animator.changeAnimationTo(fighter.pose);

        fighter.isMoving = true;

        fighter.vx = -450;
    }

    public State input(KL keyListener) {
        return null;
    }

    public State update(double deltaTime) {
        fighter.x += fighter.vx * deltaTime;

        if (!fighter.keyListener.isKeyDown(KeyEvent.VK_A)) {
            return fighter.idleState;
        }
        if (fighter.keyListener.isKeyDown(KeyEvent.VK_D)) {
            return fighter.walkForwardState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_J)) {
            return fighter.lightAttackState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_K)) {
            return fighter.mediumAttackState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_L)) {
            return fighter.heavyAttackState;
        }
        return null;
    }
}
