package player;

import component.Animator;
import component.Entity;
import player.states.*;
import util.HitBox;
import util.HurtBox;
import util.io.PlayerControls;
import window.WindowConstants;

import static player.FighterConstants.*;

import java.awt.*;
import java.util.HashMap;

public class Fighter extends Entity {

    public enum states {
        idle, crouching, walkforward, walkbackward, jump, attack, specialattack
    }

    public int jumpHeight = 650;
    public final static double gravity = 1500;
    public double ay = gravity;
    public boolean isAttacking = false;
    public boolean isMoving = false;
    public boolean isCrouching = false;

    public boolean isFacingLeft = false;

    public PlayerControls controls;
    public InputBuffer inputBuffer;

    public final static String IDLE = "IDLE";
    public final static String CROUCHING = "CROUCHING";
    public final static String WALKFORWARD = "WALKFORWARD";
    public final static String WALKBACKWARD = "WALKBACKWARD";
    public final static String JUMP = "JUMP";
    public final static String L_ATTACK = "5L";
    public final static String CROUCH_L_ATTACK = "2L";
    public final static String M_ATTACK = "5M";
    public final static String CROUCH_M_ATTACK = "2M";
    public final static String H_ATTACK = "5H";
    public final static String CROUCH_H_ATTACK = "2H";
    public final static String SWEEP = "1H";
    public final static String S_ATTACK = "5S";



    public String currAction = IDLE;

    public final Animator animator;

    public IdleState idleState;
    public CrouchingState crouchingState;
    public MoveState moveState;
    public JumpState jumpState;
    public AttackState attackState;
    public SpecialAttackState specialAttackState;


    public State currentState;

    public HashMap<String, Move> MoveList;


    public Fighter(int playerNum, FighterConstants.Characters character){
        super((int) (playerNum == 1 ? FighterConstants.PLAYER_START - 300 + IDLE_ANIMATIONS[character.ordinal()].getFrame(0).getIconWidth()/2 : FighterConstants.PLAYER_START + 300 - IDLE_ANIMATIONS[character.ordinal()].getFrame(0).getIconWidth()/2), (int) FighterConstants.PLAYER_START_Y, IDLE_ANIMATIONS[character.ordinal()].getFrame(0).getIconWidth()/2, IDLE_ANIMATIONS[character.ordinal()].getFrame(0).getIconHeight()/2, 100);

        this.controls = new PlayerControls(playerNum);
        this.inputBuffer = new InputBuffer();

        this.animator = new Animator(0.150);
        this.idleState = new IdleState(this);
        this.crouchingState = new CrouchingState(this);
        this.moveState = new MoveState(this);
        this.jumpState = new JumpState(this);
        this.attackState = new AttackState(this);
        this.specialAttackState = new SpecialAttackState(this);

        this.MoveList = new HashMap<>();

        this.currentState = idleState;

        animator.addAnimation(IDLE_ANIMATIONS[character.ordinal()], IDLE);
        animator.addAnimation(CROUCHING_ANIMATIONS[character.ordinal()], CROUCHING);
        animator.addAnimation(WALKFORWARD_ANIMATIONS[character.ordinal()], WALKFORWARD);
        animator.addAnimation(WALKBACKWARD_ANIMATIONS[character.ordinal()], WALKBACKWARD);
        animator.addAnimation(L_ATTACK_ANIMATIONS[character.ordinal()], L_ATTACK);
        animator.addAnimation(M_ATTACK_ANIMATIONS[character.ordinal()], M_ATTACK);
        animator.addAnimation(H_ATTACK_ANIMATIONS[character.ordinal()], H_ATTACK);

        animator.addAnimation(CROUCH_L_ATTACK_ANIMATIONS[character.ordinal()], CROUCH_L_ATTACK);
        animator.addAnimation(CROUCH_M_ATTACK_ANIMATIONS[character.ordinal()], CROUCH_M_ATTACK);
        animator.addAnimation(CROUCH_H_ATTACK_ANIMATIONS[character.ordinal()], CROUCH_H_ATTACK);
        animator.addAnimation(SWEEP_ANIMATIONS[character.ordinal()], SWEEP);
        animator.addAnimation(SHORYUKEN_ANIMATIONS[character.ordinal()],S_ATTACK);

        MoveList.put(L_ATTACK, L_ATTACKS[character.ordinal()]);
        MoveList.put(M_ATTACK, M_ATTACKS[character.ordinal()]);
        MoveList.put(H_ATTACK, H_ATTACKS[character.ordinal()]);
        MoveList.put(CROUCH_L_ATTACK, CROUCH_L_ATTACKS[character.ordinal()]);
        MoveList.put(CROUCH_M_ATTACK, CROUCH_M_ATTACKS[character.ordinal()]);
        MoveList.put(CROUCH_H_ATTACK, CROUCH_H_ATTACKS[character.ordinal()]);
        MoveList.put(SWEEP, SWEEPS[character.ordinal()]);
        MoveList.put(S_ATTACK, SHORYUKENS[character.ordinal()]);

        if (playerNum == 2) {
            isFacingLeft = true;
        }

    }

    public HurtBox getHurtBox() {
        int w = (int) (animator.getCurrentHurtBox().w * animator.getCurrentAnimation().scaleFactor);
        int h = (int) (animator.getCurrentHurtBox().h * animator.getCurrentAnimation().scaleFactor);

        int x = (int) (this.x + animator.getCurrentHurtBox().x + animator.getCurrentAnimation().xOffset * animator.getCurrentAnimation().scaleFactor - w/2);
        int y = (int) (this.y + animator.getCurrentHurtBox().y + animator.getCurrentAnimation().yOffset * animator.getCurrentAnimation().scaleFactor - h);

        if (isFacingLeft) {
            x = (int) (this.x - animator.getCurrentHurtBox().x + animator.getCurrentAnimation().xOffset * animator.getCurrentAnimation().scaleFactor - w/2);
        }

        return new HurtBox(x,y,w,h);
    }

    public HitBox getHitBox() {
        int w = (int) (animator.getCurrentHitBox().w * animator.getCurrentAnimation().scaleFactor);
        int h = (int) (animator.getCurrentHitBox().h * animator.getCurrentAnimation().scaleFactor);

        int x = (int) (this.x + animator.getCurrentHitBox().x + animator.getCurrentAnimation().xOffset * animator.getCurrentAnimation().scaleFactor - w/2);
        int y = (int) (this.y + animator.getCurrentHitBox().y + animator.getCurrentAnimation().yOffset * animator.getCurrentAnimation().scaleFactor - h);


        if (isFacingLeft) {
            x = (int) (this.x - animator.getCurrentHitBox().x + animator.getCurrentAnimation().xOffset * animator.getCurrentAnimation().scaleFactor - w/2);
        }

        return new HitBox(x,y,w,h);
    }

    public void changeState(State newState) {
        currentState = newState;
        currentState.enter();
    }

    public void update(double deltaTime){
        this.x = this.clamp(this.x, this.w*3, WindowConstants.SCREEN_WIDTH - this.w*3);
        inputBuffer.addInput(currAction);

//        boolean hasSequence = inputBuffer.isInputSequence(CROUCHING,WALKFORWARD,L_ATTACK);
        if (inputBuffer.isInputSequence(CROUCHING,WALKFORWARD,L_ATTACK) || inputBuffer.isInputSequence(CROUCHING,IDLE,WALKFORWARD,L_ATTACK)) {
            System.out.println("Input buffer has sequence!");
            inputBuffer.clearBuffer();
        }

        State newState = currentState.update(deltaTime);
        if (newState != null) {
            changeState(newState);
        }

        animator.update(deltaTime);
        this.originX = (this.x + this.w) / 2;
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
