//package player;
//
//import component.Animation;
//import component.Entity;
//import util.HitBox;
//import util.HurtBox;
//import util.io.KL;
//
//import java.awt.*;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Set;
//
//public class Fighter extends Entity {
//    public State currentState = new IdleState();
////    public double x;
////    public double y;
////    public double w;
////    public double h;
////    public double vx = 0;
////    double vy = 0;
//    public HitBox hitbox;
//    public HurtBox hurtbox;
//    int jumpHeight = 650;
//    public final static double gravity = 1500;
//    double ay = gravity;
//    public boolean isAttacking = false;
//
//    public KL keyListener = KL.getKeyListener();
//
//    // TESTING
//    public Animation[] animation;
//    public final static int IDLE = 0;
//    public final static int LT = 1;
//    public final static int RT = 2;
//    public final static int JUMP = 3;
//    public int pose = IDLE;
//    public static double scale = 1;
//    public boolean isMoving = false;
//
//
//    //FIXME
//    Map<String, Integer[]> frames;
//    //END
//
//    public Fighter(String name, String[] pose, int imageCount, int start, String fileType, int x, int y, int w, int h){
//        super(x, y, w, h);
//
//        // NEED TO REFACTOR
//        animation = new Animation[pose.length];
//
//        for(int i = 0;i<pose.length;i++) {
//            animation[i] = new Animation(name + "_" + pose[i], imageCount, start, 10, fileType);
//        }
//
//    }
//
////    public Fighter(String name, String[] pose, int count, int start, String fileType, int x, int y, int w, int h){
////        super(name, pose, 6, 0, ".png", x, y, w, h);
////        this.x = x;
////        this.y = y;
////        this.w = w;
////        this.h = h;
////    }
//
////    public State FighterState {
////        IDLE(){
////            void init() {
////
////            }
////        },
////        CROUCHING(){},
////        JUMP(){},
////        JUMP_FORWARD(){},
////        JUMP_BACKWARD(){},
////        WALK_FORWARD(){},
////        WALK_BACKWARD(){},
////        LIGHT_ATTACK(){},
////        MEDIUM_ATTACK(){},
////        HEAVY_ATTACK(){},
////    }
//
//    public void changeState(State newState) {
////        currentState.exit();
//        // Do I need to clear old state from mem?
//        currentState = newState;
//        currentState.enter(this);
////        this.currentState = newState;
//    }
//
////    void input(KL keyListener) {
////        State newState = currentState.input(keyListener);
////        if (newState != null) {
////            changeState(newState);
////        }
////    }
//
//    public void update(Fighter fighter, double deltaTime){
//        State newState = currentState.update(this, deltaTime);
//        if (newState != null) {
//            changeState(newState);
//        }
//        System.out.println("Current State: " + currentState.toString());
//    }
//
//    public void draw(Graphics g){
//        super.draw(g);
//
//        // TEST
//        Image temp;
//
//        if (!isMoving) {
//            temp = animation[pose].getStaticImage();
//        } else {
//            temp = animation[pose].getCurrentImage();
//        }
//
//        w = scale * temp.getWidth(null);
//        h = scale * temp.getHeight(null);
//
//        g.drawImage(temp, (int)x, (int)y, (int)w, (int)h, null);
//        // END TEST
//
//        if (this.isAttacking) {
//            this.hitbox = new HitBox((int) (this.x + FighterConstants.PLAYER_WIDTH),(int) this.y + 50,150,70);
//            hitbox.draw(g);
//
//
//            this.isAttacking = false;
//        }
////        g.setColor(FighterConstants.characterColor);
////        g.fillRect((int) this.x, (int) this.y, (int) FighterConstants.PLAYER_WIDTH, (int) FighterConstants.PLAYER_HEIGHT);
//
//    }
//
//}
