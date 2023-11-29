package player.states;

import player.Fighter;
import util.io.KL;

import java.awt.event.KeyEvent;

public class CrouchingState extends State {
    private KL keyListener = KL.getKeyListener();

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
        if (!fighter.keyListener.isKeyDown(KeyEvent.VK_S)) {
            fighter.isCrouching = false;
            return fighter.idleState;
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
        return fighter.crouchingState;
    }

}
