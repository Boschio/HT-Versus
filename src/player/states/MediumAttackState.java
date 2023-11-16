package player.states;

import player.Fighter;
import util.io.KL;

public class MediumAttackState extends State {
    public MediumAttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.pose = fighter.MEDIUMATTACK;
        fighter.animator.changeAnimationTo(fighter.pose);

        fighter.isAttacking = true;
    }

    public State input(KL e) {
        return null;
    }

    public State update(double deltaTime) {
        while(fighter.animator.getCurrentFrameIndex() > 0) {
            return null;
        }

        return fighter.idleState;
    }

    private void HandleAttack(){
        fighter.isAttacking = true;
    }
}
