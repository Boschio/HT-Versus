package player;

import component.Animator;
import component.Entity;
import util.HitBox;
import util.HurtBox;
import util.io.KL;

import java.awt.*;

public class Fighter extends Entity {
    public State currentState = new IdleState();

    public HitBox hitbox;
    public HurtBox hurtbox;
    int jumpHeight = 650;
    public final static double gravity = 1500;
    double ay = gravity;
    public boolean isAttacking = false;

    public KL keyListener = KL.getKeyListener();

    // TESTING
    public final static String IDLE = "IDLE";
    public final static String WALKFORWARD = "WALKFORWARD";
    public final static String WALKBACKWARD = "WALKBACKWARD";
    public final static String JUMP = "JUMP";
    public final static String ATTACK = "ATTACK";

    public String pose = IDLE;
    public boolean isMoving = false;

    public int originPoint;


    //FIXME
    protected final Animator animator;

    IdleState idleState = new IdleState();
    WalkForwardState WalkForwardState = new WalkForwardState();
    //END

    public Fighter(String name, int x, int y, int w, int h){
        super(x, y, (int)(w*scale), (int)(w*scale));

        this.animator = new Animator(0.150);
    }

    public void changeState(State newState) {
        currentState = newState;
        currentState.enter(this);
    }

    public void update(Fighter fighter, double deltaTime){
        State newState = currentState.update(this, deltaTime);
        if (newState != null) {
            changeState(newState);
        }
        animator.update(deltaTime);

        System.out.println("Current State: " + currentState.toString());
    }

    public void draw(Graphics g){
        super.draw(g);

        if(animator.hasAnimations()) {
            animator.RenderCurrentSprite(g, (int) x, (int) y);
        }

        if (this.isAttacking) {
            this.hitbox = new HitBox((int) (this.x + FighterConstants.PLAYER_WIDTH),(int) this.y + 50,150,70);
            hitbox.draw(g);

            this.isAttacking = false;
        }
    }

}
