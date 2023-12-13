package player.states;

import player.Fighter;

public class WalkForwardState extends State {
    public WalkForwardState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.currAction = fighter.WALKFORWARD;

        fighter.animator.changeAnimationTo(fighter.currAction);

        fighter.isMoving = true;

        fighter.vx = 450;
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
