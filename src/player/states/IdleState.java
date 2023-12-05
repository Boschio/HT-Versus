package player.states;

import player.Fighter;
import util.io.KL;

public class IdleState extends State {

    public IdleState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.isMoving = false;
        fighter.isCrouching = false;
        fighter.pose = fighter.IDLE;
        fighter.vx = 0.0;

        fighter.animator.changeAnimationTo(fighter.pose);
    }

    public State input(KL e) {
//        if (e.isKeyDown(KeyEvent.VK_A) || e.isKeyDown(KeyEvent.VK_D)) {
//            return new MoveState();
//        }
        return null;
    }

    public State update(double deltaTime) {
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.crouchingState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            return fighter.walkBackwardState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            return fighter.walkForwardState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.JUMP)){
            return fighter.jumpState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.JUMP) && fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)){
//            return fighter.jumpForwardState;
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
