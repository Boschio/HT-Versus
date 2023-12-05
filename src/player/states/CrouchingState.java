package player.states;

import player.Fighter;
import util.io.KL;

public class CrouchingState extends State {
    public CrouchingState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
//        fighter.isMoving = false;
        fighter.isCrouching = true;
        fighter.pose = fighter.CROUCHING;
//        fighter.vx = 0.0;

        fighter.animator.changeAnimationTo(fighter.pose);
    }

    public State input(KL e) {

        return null;
    }

    public State update(double deltaTime) {
        if (!fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.idleState;
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
        return fighter.crouchingState;
    }

}
