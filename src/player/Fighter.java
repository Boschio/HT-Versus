package player;

import component.Animator;
import component.Entity;
import player.states.*;
import util.HitBox;
import util.HurtBox;
import util.io.PlayerControls;

import java.awt.*;
import java.util.HashMap;

public class Fighter extends Entity {
    public int jumpHeight = 650;
    public final static double gravity = 1500;
    public double ay = gravity;
    public boolean isAttacking = false;

    public boolean isFacingLeft = false;

    public PlayerControls controls;

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


    public Fighter(int playerNum, FighterConstants.Characters character){
        super((int) (playerNum == 1 ? FighterConstants.PLAYER1_START_X : FighterConstants.PLAYER2_START_X), (int) FighterConstants.PLAYER_START_Y-100, 80, 80, 100);

        this.controls = new PlayerControls(playerNum);

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

        animator.addAnimation(FighterConstants.IDLE_ANIMATIONS[character.value], "IDLE");
        animator.addAnimation(FighterConstants.CROUCHING_ANIMATIONS[character.value], "CROUCHING");
        animator.addAnimation(FighterConstants.WALKFORWARD_ANIMATIONS[character.value], "WALKFORWARD");
        animator.addAnimation(FighterConstants.WALKBACKWARD_ANIMATIONS[character.value], "WALKBACKWARD");
        animator.addAnimation(FighterConstants.LIGHTATTACK_ANIMATIONS[character.value], "LIGHTATTACK");
        animator.addAnimation(FighterConstants.MEDIUMATTACK_ANIMATIONS[character.value], "MEDIUMATTACK");
        animator.addAnimation(FighterConstants.HEAVYATTACK_ANIMATIONS[character.value], "HEAVYATTACK");

        animator.addAnimation(FighterConstants.CROUCHLIGHTATTACK_ANIMATIONS[character.value], "CROUCHLIGHTATTACK");
        animator.addAnimation(FighterConstants.CROUCHMEDIUMATTACK_ANIMATIONS[character.value], "CROUCHMEDIUMATTACK");
        animator.addAnimation(FighterConstants.CROUCHHEAVYATTACK_ANIMATIONS[character.value], "CROUCHHEAVYATTACK");
        animator.addAnimation(FighterConstants.SWEEP_ANIMATIONS[character.value], "SWEEP");

        if (playerNum == 2) {
            isFacingLeft = true;
        }

    }

    public void changeState(State newState) {
        currentState = newState;
        currentState.enter();
    }

    public HurtBox getHurtBox() {
        int w = (int) (animator.getCurrentHurtBox().w * animator.getCurrentAnimation().scaleFactor);
        int h = (int) (animator.getCurrentHurtBox().h * animator.getCurrentAnimation().scaleFactor);

        int x = (int) (animator.getCurrentHurtBox().x + this.x + animator.getCurrentAnimation().xOffset * animator.getCurrentAnimation().scaleFactor - w/2);
        int y = (int) (animator.getCurrentHurtBox().y + this.y + animator.getCurrentAnimation().yOffset * animator.getCurrentAnimation().scaleFactor - h);

        if (isFacingLeft) {
//            w = -w;
        }

        return new HurtBox(x,y,w,h);
    }

    public HitBox getHitBox() {
        int w = (int) (animator.getCurrentHitBox().w * animator.getCurrentAnimation().scaleFactor);
        int h = (int) (animator.getCurrentHitBox().h * animator.getCurrentAnimation().scaleFactor);

        int x = (int) (animator.getCurrentHitBox().x + this.x + animator.getCurrentAnimation().xOffset * animator.getCurrentAnimation().scaleFactor - w/2);
        int y = (int) (animator.getCurrentHitBox().y + this.y + animator.getCurrentAnimation().yOffset * animator.getCurrentAnimation().scaleFactor - h);

        if (isFacingLeft) {
//            w = -w;
        }

        return new HitBox(x,y,w,h);
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
            if (!isFacingLeft) {
                animator.RenderCurrentSprite(g, (int) x, (int) y);
                if (animator.getCurrentHurtBox() != null) {
                    animator.RenderCurrentHurtBox(g, (int) x, (int) y);
                }
                if (animator.getCurrentHitBox() != null) {
                    animator.RenderCurrentHitBox(g, (int) x, (int) y);
                }
            } else {
                animator.RenderCurrentSpriteFlipVer(g, (int) x, (int) y);
                if (animator.getCurrentHurtBox() != null) {
                    animator.RenderCurrentHurtBoxFlip(g, (int) x, (int) y);
                }
                if (animator.getCurrentHitBox() != null) {
                    animator.RenderCurrentHitBoxFlip(g, (int) x, (int) y);
                }
            }

        }
    }

}
