package player.states;

import player.Fighter;
import util.io.KL;

public class WalkBackwardState extends State {
    public WalkBackwardState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.currAction = fighter.WALKBACKWARD;
        fighter.animator.changeAnimationTo(fighter.currAction);

        fighter.isMoving = true;

        fighter.vx = -450;
    }

    public State input(KL keyListener) {
        return null;
    }

    public State update(double deltaTime) {
        fighter.x += fighter.vx * deltaTime;

        if (!fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            return fighter.idleState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.crouchingState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            return fighter.walkForwardState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
            return fighter.lightAttackState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
            return fighter.mediumAttackState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
            return fighter.heavyAttackState;
        }
        return null;
    }
}
