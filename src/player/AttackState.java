package player;

import util.io.KL;

public class AttackState implements State{
    @Override
    public void enter(Fighter fighter) {
        fighter.pose = fighter.ATTACK;
        fighter.animator.changeAnimationTo(fighter.pose);

        fighter.isAttacking = true;
    }

    @Override
    public State input(KL e) {
        return null;
    }

    @Override
    public State update(Fighter fighter, double deltaTime) {
        while(fighter.animator.getCurrentFrameIndex() > 0) {
            return null;
        }
//        HandleAttack(fighter);
        return new IdleState();
    }

    private void HandleAttack(Fighter fighter){
        fighter.isAttacking = true;
    }
}
