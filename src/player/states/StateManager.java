//package player.states;
//
//
//import player.Fighter;
//
//import java.awt.event.KeyEvent;
//
//abstract class State {
//    Fighter fighter;
//    static State idle, crouching, walkforward, walkbackward, jump, attack, current;
//
//    State(Fighter fighter) {
//        this.fighter = fighter;
//    }
//
//    void enter(){}
//    void update(double deltaTime){}
//}
//
//class Idle extends State {
//    Idle(Fighter fighter) {
//        super(fighter);
//    }
//
//    void enter() {
//        fighter.isMoving = false;
//        fighter.isCrouching = false;
//        fighter.currAction = fighter.IDLE;
//        fighter.vx = 0.0;
//
//        fighter.animator.changeAnimationTo(fighter.currAction);
//    }
//
//    void update(double deltaTime) {
////        int keyPressed = fighter.controls.keyListener.keyPressed;
////        int keyPressed = KeyEvent.VK_D;
////        switch(keyPressed) {
////            case KeyEvent.VK_W:
////                current = jump;
////                return;
////            case KeyEvent.VK_A:
////                current = walkbackward;
////                return;
////            case KeyEvent.VK_D:
////                current = walkforward;
////                return;
////            case KeyEvent.VK_S:
////                current = crouching;
////                return;
////            case KeyEvent.VK_J:
////            case KeyEvent.VK_K:
////            case KeyEvent.VK_L:
////                current = attack;
////                return;
////            default:
//////                current = idle;
////                return;
////        }
//
//        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
//            current = crouching;
//        }
//        if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
//            current = walkbackward;
//        }
//        if (fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
//            current = walkforward;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.JUMP)){
//            current = jump;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.JUMP) && fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)){
////            fighter.currentState = Fighter.States.jumpForward;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
//            current = attack;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
//            current = attack;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
//            current = attack;
//        }
//    }
//
//}
//class Crouching extends State {
//    Crouching(Fighter fighter) {
//        super(fighter);
//    }
//
//    void enter() {
//
//    }
//
//    void update(double deltaTime) {
//        int keyPressed = fighter.controls.keyListener.keyPressed;
//        switch(keyPressed) {
//            case KeyEvent.VK_W:
//                current = jump;
//                return;
//            case KeyEvent.VK_A:
//                current = walkbackward;
//                return;
//            case KeyEvent.VK_D:
//                current = walkforward;
//                return;
//            case KeyEvent.VK_S:
//                current = crouching;
//                return;
//            case KeyEvent.VK_J:
//            case KeyEvent.VK_K:
//            case KeyEvent.VK_L:
//                current = attack;
//                return;
//            default:
//                return;
//        }
//    }
//}
//class WalkForward extends State {
//    WalkForward(Fighter fighter) {
//        super(fighter);
//    }
//
//    void enter() {
//        fighter.currAction = fighter.WALKFORWARD;
////        if (fighter.prevState != fighter.currentState) {
//            fighter.animator.changeAnimationTo(fighter.currAction);
////        }
//
//        fighter.isMoving = true;
//
//        fighter.vx = 450;
//    }
//
//    void update(double deltaTime) {
//////        int keyPressed = fighter.controls.keyListener.keyPressed;
////        int keyPressed = KeyEvent.VK_D;
////        switch(keyPressed) {
////            case KeyEvent.VK_W:
////                current = jump;
////                return;
////            case KeyEvent.VK_A:
////                current = walkbackward;
////                return;
////            case KeyEvent.VK_D:
////                current = walkforward;
////                return;
////            case KeyEvent.VK_S:
////                current = crouching;
////                return;
////            case KeyEvent.VK_J:
////            case KeyEvent.VK_K:
////            case KeyEvent.VK_L:
////                current = attack;
////                return;
////            default:
////                return;
////        }
//        fighter.x += fighter.vx * deltaTime;
//
//        if (!fighter.controls.keyListener.isKeyDown(fighter.controls.RIGHT)) {
//            current = idle;
//            return;
//        }
//        if (fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
//            current = crouching;
//            return;
//        }
//        if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT)) {
//            current = walkbackward;
//            return;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
//            current = attack;
//            return;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
//            current = attack;
//            return;
//        }
//        if(fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
//            current = attack;
//            return;
//        }
//        return;
//    }
//}
//class WalkBackward extends State {
//    WalkBackward(Fighter fighter) {
//        super(fighter);
//    }
//
//    void enter() {
//        fighter.currAction = fighter.WALKBACKWARD;
//        fighter.animator.changeAnimationTo(fighter.currAction);
//
//        fighter.isMoving = true;
//
//        fighter.vx = -450;
//    }
//
//    void update(double deltaTime) {
//        int keyPressed = fighter.controls.keyListener.keyPressed;
//        switch(keyPressed) {
//            case KeyEvent.VK_W:
//                current = jump;
//                return;
//            case KeyEvent.VK_A:
//                current = walkbackward;
//                return;
//            case KeyEvent.VK_D:
//                current = walkforward;
//                return;
//            case KeyEvent.VK_S:
//                current = crouching;
//                return;
//            case KeyEvent.VK_J:
//            case KeyEvent.VK_K:
//            case KeyEvent.VK_L:
//                current = attack;
//                return;
//            default:
//                return;
//        }
//    }
//}
//class Jump extends State {
//    Jump(Fighter fighter) {
//        super(fighter);
//    }
//
//    void enter() {
//
//    }
//
//    void update(double deltaTime) {
//        int keyPressed = fighter.controls.keyListener.keyPressed;
//        switch(keyPressed) {
//            case KeyEvent.VK_W:
//                current = jump;
//                return;
//            case KeyEvent.VK_A:
//                current = walkbackward;
//                return;
//            case KeyEvent.VK_D:
//                current = walkforward;
//                return;
//            case KeyEvent.VK_S:
//                current = crouching;
//                return;
//            case KeyEvent.VK_J:
//            case KeyEvent.VK_K:
//            case KeyEvent.VK_L:
//                current = attack;
//                return;
//            default:
//                return;
//        }
//    }
//}
//class Attack extends State {
//    Attack(Fighter fighter) {
//        super(fighter);
//    }
//
//    void enter() {
//        fighter.isAttacking = true;
////        fighter.stateManager.stateLock = true;
//
//        if (fighter.isCrouching && fighter.controls.keyListener.isKeyDown(fighter.controls.CROUCH)) {
//            if (fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
//                fighter.currAction = fighter.CROUCH_L_ATTACK;
//            }
//            if (fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
//                fighter.currAction = fighter.CROUCH_M_ATTACK;
//            }
//            if (!fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT) && fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
//                fighter.currAction = fighter.CROUCH_H_ATTACK;
//            }
//            if (fighter.controls.keyListener.isKeyDown(fighter.controls.LEFT) && fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
//                fighter.currAction = fighter.SWEEP;
//            }
//        } else {
//            if (fighter.controls.keyListener.isKeyDown(fighter.controls.L_ATTACK)) {
//                fighter.currAction = fighter.L_ATTACK;
//            }
//            if (fighter.controls.keyListener.isKeyDown(fighter.controls.M_ATTACK)) {
//                fighter.currAction = fighter.M_ATTACK;
//            }
//            if (fighter.controls.keyListener.isKeyDown(fighter.controls.H_ATTACK)) {
//                fighter.currAction = fighter.H_ATTACK;
//            }
//
//        }
//        if (fighter.prevState != fighter.currentState) {
//            fighter.MoveList.get(fighter.currAction);
//            fighter.animator.changeAnimationTo(fighter.currAction);
//        }
//    }
//
//    void update(double deltaTime) {
//        int keyPressed = fighter.controls.keyListener.keyPressed;
//        switch(keyPressed) {
//            case KeyEvent.VK_W:
//                current = jump;
//                return;
//            case KeyEvent.VK_A:
//                current = walkbackward;
//                return;
//            case KeyEvent.VK_D:
//                current = walkforward;
//                return;
//            case KeyEvent.VK_S:
//                current = crouching;
//                return;
//            case KeyEvent.VK_J:
//            case KeyEvent.VK_K:
//            case KeyEvent.VK_L:
//                current = attack;
//                return;
//            default:
//                current = idle;
//                return;
//        }
//    }
//}
//
//public class StateManager {
//
//    Fighter fighter;
//    public Idle idle;
//    public Crouching crouching;
//    public WalkForward walkForward;
//    public WalkBackward walkBackward;
//    public Jump jump;
//    public Attack attack;
//
//    public StateManager(Fighter fighter) {
//        this.fighter = fighter;
//        this.idle = new Idle(fighter);
//        this.crouching = new Crouching(fighter);
//        this.walkBackward = new WalkBackward(fighter);
//        this.walkForward = new WalkForward(fighter);
//        this.jump = new Jump(fighter);
//        this.attack = new Attack(fighter);
//
//        State.current = idle;
//    }
//
//    public void update(double deltaTime) {
//        State.current.enter();
//        State.current.update(deltaTime);
//    }
//
//}
