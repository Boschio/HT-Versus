package player.states;

import player.Fighter;
import util.io.KL;

public class CrouchingState extends State {
    public CrouchingState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.isMoving = false;
        fighter.isCrouching = true;
        fighter.currAction = fighter.CROUCHING;

        fighter.animator.changeAnimationTo(fighter.currAction);
    }

    public State update(double deltaTime) {

        if (!fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.idleState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
            return fighter.attackState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
            return fighter.attackState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
            return fighter.attackState;
        }

        return null;
    }

}
