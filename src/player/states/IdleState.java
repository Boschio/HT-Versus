package player.states;

import player.Fighter;
import util.io.KL;

import java.awt.event.KeyEvent;

public class IdleState extends State {
    private KL keyListener = KL.getKeyListener();

    public IdleState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.isMoving = false;
        fighter.pose = fighter.IDLE;
        fighter.vx = 0.0;

        fighter.animator.changeAnimationTo(Fighter.IDLE);
    }

    public State input(KL e) {
//        if (e.isKeyDown(KeyEvent.VK_A) || e.isKeyDown(KeyEvent.VK_D)) {
//            return new MoveState();
//        }
        return null;
    }

    public State update(double deltaTime) {
        if (keyListener.isKeyDown(KeyEvent.VK_A)) {
//            return new WalkBackwardState();
            return fighter.walkBackwardState;
        }
        if (keyListener.isKeyDown(KeyEvent.VK_D)) {
//            return new WalkForwardState();
            return fighter.walkForwardState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_W)){
//            return new JumpState();
            return fighter.jumpState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_W) && fighter.keyListener.isKeyDown(KeyEvent.VK_D)){
//            return new JumpForwardState();
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_J)) {
//            return new LightAttackState();
            return fighter.lightAttackState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_K)) {
//            return new MediumAttackState();
            return fighter.mediumAttackState;
        }
        if(fighter.keyListener.isKeyDown(KeyEvent.VK_L)) {
//            return new HeavyAttackState();
            return fighter.heavyAttackState;
        }
        return null;
    }
}
