package player;

import component.Animator;
import component.Entity;
import player.states.*;
import util.io.KL;

import java.awt.*;
import java.util.HashMap;

public class Fighter extends Entity {
    public int jumpHeight = 650;
    public final static double gravity = 1500;
    public double ay = gravity;
    public boolean isAttacking = false;

    public KL keyListener = KL.getKeyListener();

    // TESTING
    public final static String IDLE = "IDLE";
    public final static String CROUCHING = "CROUCHING";
    public final static String WALKFORWARD = "WALKFORWARD";
    public final static String WALKBACKWARD = "WALKBACKWARD";
    public final static String JUMP = "JUMP";
    public final static String LIGHTATTACK = "LIGHTATTACK";
    public final static String CROUCHLIGHTATTACK = "CROUCHLIGHTATTACK";
    public final static String MEDIUMATTACK = "MEDIUMATTACK";
    public final static String CROUCHMEDIUMATTACK = "CROUCHMEDIUMATTACK";
    public final static String HEAVYATTACK = "HEAVYATTACK";
    public final static String CROUCHHEAVYATTACK = "CROUCHHEAVYATTACK";
    public final static String SWEEP = "SWEEP";


    public String pose = IDLE;
    public boolean isMoving = false;
    public boolean isCrouching = false;

    public String name;
    public final Animator animator;
    public IdleState idleState;
    public CrouchingState crouchingState;
    public WalkForwardState walkForwardState;
    public WalkBackwardState walkBackwardState;
    public JumpState jumpState;
    public LightAttackState lightAttackState;
    public MediumAttackState mediumAttackState;
    public HeavyAttackState heavyAttackState;
    public State currentState;

    public HashMap<String, Move> MoveList;


    public Fighter(String name, int x, int y, int w, int h, double maxHealth){
        super(x, y, (int)(w*scale), (int)(h*scale), maxHealth);

        this.name = name;

        this.animator = new Animator(0.150);
        this.idleState = new IdleState(this);
        this.crouchingState = new CrouchingState(this);
        this.walkForwardState = new WalkForwardState(this);
        this.walkBackwardState = new WalkBackwardState(this);
        this.jumpState = new JumpState(this);
        this.lightAttackState = new LightAttackState(this);
        this.mediumAttackState = new MediumAttackState(this);
        this.heavyAttackState = new HeavyAttackState(this);

        this.currentState = idleState;
    }

    public void changeState(State newState) {
        currentState = newState;
        currentState.enter();
    }

    public void update(double deltaTime){
        State newState = currentState.update(deltaTime);
        if (newState != null) {
            changeState(newState);
        }
        animator.update(deltaTime);

//        System.out.println("Current State: " + currentState.toString());
    }

    public void draw(Graphics g){
        super.draw(g);

        if(animator.hasAnimations()) {
            animator.RenderCurrentSprite(g, (int) x, (int) y);
            if (animator.getCurrentHurtBox() != null) {
                animator.RenderCurrentHurtBox(g, (int) x, (int) y);
            }
            if (animator.getCurrentHitBox() != null) {
                animator.RenderCurrentHitBox(g, (int) x, (int) y);
            }
        }

        if (this.isAttacking && this.animator.getCurrentFrameIndex() < this.animator.getCurrentAnimation().getHitBoxesLength()) {

        } else {
            this.isAttacking = false;
        }
    }

}
