package player.states;

import player.Fighter;
import util.io.KL;

public class HeavyAttackState extends State {
    public HeavyAttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        if (fighter.isCrouching && fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
            fighter.pose = fighter.SWEEP;
        } else if (fighter.isCrouching && !fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)){
            fighter.pose = fighter.CROUCHHEAVYATTACK;
        } else {
            fighter.pose = fighter.HEAVYATTACK;
        }

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
        if (fighter.isCrouching) {
            return fighter.crouchingState;
        }

        return fighter.idleState;
    }

    private void HandleAttack(){
        fighter.isAttacking = true;
    }
}
