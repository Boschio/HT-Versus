package player;

import component.Sprite;
import util.HitBox;
import util.HurtBox;
import util.io.KL;

import java.awt.*;

public class Fighter extends Sprite {
    public State currentState = new IdleState();
//    public double x;
//    public double y;
//    public double w;
//    public double h;
//    public double vx = 0;
//    double vy = 0;
    public HitBox hitbox;
    public HurtBox hurtbox;
    int jumpHeight = 650;
    public final static double gravity = 1500;
    double ay = gravity;
    public boolean isAttacking = false;

    public KL keyListener = KL.getKeyListener();

    public Fighter(String name, String[] pose, int count, int start, String fileType, int x, int y, int w, int h){
        super(name, pose, 6, 0, ".png", x, y, w, h);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

//    public State FighterState {
//        IDLE(){
//            void init() {
//
//            }
//        },
//        CROUCHING(){},
//        JUMP(){},
//        JUMP_FORWARD(){},
//        JUMP_BACKWARD(){},
//        WALK_FORWARD(){},
//        WALK_BACKWARD(){},
//        LIGHT_ATTACK(){},
//        MEDIUM_ATTACK(){},
//        HEAVY_ATTACK(){},
//    }

    public void changeState(State newState) {
//        currentState.exit();
        // Do I need to clear old state from mem?
        currentState = newState;
        currentState.enter(this);
//        this.currentState = newState;
    }

    void input(KL keyListener) {
        State newState = currentState.input(keyListener);
        if (newState != null) {
            changeState(newState);
        }
    }

    public void update(Fighter fighter, double deltaTime){
        State newState = currentState.update(this, deltaTime);
        if (newState != null) {
            changeState(newState);
        }
        System.out.println("Current State: " + currentState.toString());
    }

    public void draw(Graphics g){
        super.draw(g);
        if (this.isAttacking) {
            this.hitbox = new HitBox((int) (this.x + FighterConstants.PLAYER_WIDTH),(int) this.y + 50,150,70);
            hitbox.draw(g);


            this.isAttacking = false;
        }
//        g.setColor(FighterConstants.characterColor);
//        g.fillRect((int) this.x, (int) this.y, (int) FighterConstants.PLAYER_WIDTH, (int) FighterConstants.PLAYER_HEIGHT);

    }

}
