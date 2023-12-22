package player.states;

import player.Fighter;

public class SpecialAttackState extends State {

    public SpecialAttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.isAttacking = true;

        fighter.currAction = fighter.S_ATTACK;

        fighter.animator.changeAnimationTo(fighter.currAction);

    }

    public State update(double deltaTime) {
        if(fighter.animator.getCurrentFrameIndex() >=  fighter.animator.getCurrentAnimation().getAnimationLength()-1) {
            return fighter.idleState;
        }

        return null;
    }
}
