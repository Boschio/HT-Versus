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
        fighter.currAction = fighter.IDLE;
        fighter.vx = 0.0;

        fighter.animator.changeAnimationTo(fighter.currAction);
    }

    public State input(KL e) {
//        if (e.isKeyDown(KeyEvent.VK_A) || e.isKeyDown(KeyEvent.VK_D)) {
//            return new MoveState();
//        }
        return null;
    }

    public State update(double deltaTime) {
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            return fighter.stateManager.crouchingState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            return fighter.stateManager.walkBackwardState;
        }
        if (fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
            return fighter.stateManager.walkForwardState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.JUMP)){
            return fighter.stateManager.jumpState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.JUMP) && fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)){
//            return fighter.stateManager.jumpForwardState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
            return fighter.stateManager.attackState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
            return fighter.stateManager.attackState;
        }
        if(fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
            return fighter.stateManager.attackState;
        }
        return this;
    }
}
