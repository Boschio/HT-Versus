package player.states;

import player.Fighter;

public class MoveState extends State {
    public MoveState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        if (!fighter.isFacingLeft && fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            fighter.currAction = fighter.WALKFORWARD;
            fighter.vx = 450;
        }
        if (!fighter.isFacingLeft && fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            fighter.currAction = fighter.WALKBACKWARD;
            fighter.vx = -450;
        }
        if (fighter.isFacingLeft && fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            fighter.currAction = fighter.WALKBACKWARD;
            fighter.vx = 450;
        }
        if (fighter.isFacingLeft && fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            fighter.currAction = fighter.WALKFORWARD;
            fighter.vx = -450;
        }

        fighter.animator.changeAnimationTo(fighter.currAction);
        fighter.isMoving = true;
    }

    public State update(double deltaTime) {
        fighter.x += fighter.vx * deltaTime;

        if (!fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT) && !fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT) ||
                fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT) && fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            return fighter.idleState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.crouchingState;
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
