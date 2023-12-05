package player.states;

import player.Fighter;
import util.io.KL;

public class WalkForwardState extends State {
    public WalkForwardState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.pose = fighter.WALKFORWARD;
        fighter.animator.changeAnimationTo(fighter.pose);

        fighter.isMoving = true;

        fighter.vx = 450;
    }

    public State input(KL keyListener) {
        return null;
    }

    public State update(double deltaTime) {
        fighter.x += fighter.vx * deltaTime;

        if (!fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            return fighter.idleState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.crouchingState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            return fighter.walkBackwardState;
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
