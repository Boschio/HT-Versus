//package player;
//
//import util.io.KL;
//
//import java.awt.event.KeyEvent;
//
//public class MoveState implements State {
//    @Override
//    public void enter(Fighter fighter) {
//
//    }
//
////    @Override
////    public void exit() {
////
////    }
//
//    @Override
//    public State input(KL e) {
//        if(e.isKeyDown(KeyEvent.VK_W)){
//            return new JumpState();
//        }
//        return null;
//    }
//
//    @Override
//    public State update(Fighter fighter, double deltaTime) {
//        HandleMovement(fighter);
//        if (!fighter.keyListener.isKeyDown(KeyEvent.VK_A) || !fighter.keyListener.isKeyDown(KeyEvent.VK_D)) {
//            return new IdleState();
//        }
//        return new MoveState();
//    }
//
//    private void HandleMovement(Fighter fighter){
//        if(fighter.keyListener.isKeyDown(KeyEvent.VK_A)){
//            fighter.x -= 3.0;
//        } else if(fighter.keyListener.isKeyDown(KeyEvent.VK_D)){
//            fighter.x += 3.0;
//        }
//    }
//}
