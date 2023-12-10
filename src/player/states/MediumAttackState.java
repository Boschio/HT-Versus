//package player.states;
//
//import player.Fighter;
//import util.io.KL;
//
//public class MediumAttackState extends State {
//    public MediumAttackState(Fighter fighter) {
//        super(fighter);
//    }
//
//    public void enter() {
//        if (fighter.isCrouching && fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
//            fighter.currAction = fighter.CROUCH_M_ATTACK;
//        } else {
//            fighter.currAction = fighter.M_ATTACK;
//        }
//
//        fighter.animator.changeAnimationTo(fighter.currAction);
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
//        if (fighter.isCrouching) {
//            return fighter.crouchingState;
//        }
//
//        return fighter.idleState;
//    }
//
//    private void HandleAttack(){
//        fighter.isAttacking = true;
//    }
//}
