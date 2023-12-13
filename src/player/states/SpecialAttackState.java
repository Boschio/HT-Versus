package player.states;

import player.Fighter;
import player.FighterConstants;

public class SpecialAttackState extends State {

    public SpecialAttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.isAttacking = true;
        fighter.vy -= fighter.jumpHeight;
//        fighter.stateManager.stateLock = true;

        if (fighter.controls.keyListener.isKeyDown(fighter.controls.S_ATTACK)) {
            fighter.currAction = fighter.S_ATTACK;
        }

        fighter.animator.changeAnimationTo(fighter.currAction);

    }

    public State update(double deltaTime) {

        if(fighter.animator.getCurrentFrameIndex() >=  fighter.animator.getCurrentAnimation().getAnimationLength()-1) {
            return fighter.idleState;
        }
        fighter.y += fighter.vy * deltaTime;
        fighter.vy += fighter.ay * deltaTime;

        if (fighter.animator.getCurrentFrame().getIconHeight() + fighter.y >= FighterConstants.FLOOR) {
            pushAbove(FighterConstants.FLOOR);
            stopFalling();

            return fighter.idleState;
        }
        return null;
    }
    public void stopFalling() {
        fighter.vx = 0;
        fighter.vy = 0;
    }

    public void pushAbove(double floor) {
        fighter.y = floor - fighter.animator.getCurrentFrame().getIconHeight() - 1;
    }
}
