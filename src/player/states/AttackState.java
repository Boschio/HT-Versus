package player.states;

import player.Fighter;
import util.io.KL;

public class AttackState extends State{

    public AttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        while(fighter.isAttacking && fighter.isCrouching) {

        }
//        fighter.pose = fighter.ATTACK;
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
//        HandleAttack(fighter);
        return fighter.idleState;
    }

    private void HandleAttack(Fighter fighter){
        fighter.isAttacking = true;
    }
}
