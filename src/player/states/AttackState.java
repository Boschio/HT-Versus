//package player.states;
//
//import player.Fighter;
//import util.io.KL;
//
//public class AttackState extends State{
//
//    public AttackState(FighterOld fighter) {
//        super(fighter);
//    }
//
//    public void enter() {
//        while(fighter.isAttacking && fighter.isCrouching) {
//
//        }
////        fighter.pose = fighter.ATTACK;
//        fighter.animator.changeAnimationTo(fighter.pose);
//
//        fighter.isAttacking = true;
//    }
//
//    public State input(KL e) {
//        return null;
//    }
//
//    public State update(double deltaTime) {
//        while(fighter.animator.getCurrentFrameIndex() > 0) {
//            return null;
//        }
////        HandleAttack(fighter);
//        return fighter.idleState;
//    }
//
//    private void HandleAttack(FighterOld fighter){
//        fighter.isAttacking = true;
//    }
//}

package player.states;

import player.Fighter;

public class AttackState extends State {

    public AttackState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.isAttacking = true;

        if (fighter.isCrouching && fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
            if (fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
                fighter.currAction = fighter.CROUCH_L_ATTACK;
            }
            if (fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
                fighter.currAction = fighter.CROUCH_M_ATTACK;
            }
            if (!fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT) && fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
                fighter.currAction = fighter.CROUCH_H_ATTACK;
            }
            if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT) && fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
                fighter.currAction = fighter.SWEEP;
            }
        } else {
            if (fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
                fighter.currAction = fighter.L_ATTACK;
            }
            if (fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
                fighter.currAction = fighter.M_ATTACK;
            }
            if (fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
                fighter.currAction = fighter.H_ATTACK;
            }

        }

        fighter.MoveList.get(fighter.currAction);
        fighter.animator.changeAnimationTo(fighter.currAction);

    }

    public State update(double deltaTime) {
        if(fighter.animator.getCurrentFrameIndex() >= fighter.animator.getCurrentAnimation().getAnimationLength()-1) {
            return fighter.idleState;
        }
        if(fighter.controls.keyListener.isKeyHeld())
            return null;
//        HandleAttack(fighter);
        return null;
    }

    private void HandleAttack(Fighter fighter){
        fighter.isAttacking = true;
    }
}