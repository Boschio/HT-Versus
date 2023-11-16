package player.states;

import player.Fighter;
import util.io.KL;

public class LightAttackState extends State {
    public LightAttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.pose = fighter.LIGHTATTACK;
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
