package player;

import component.Animation;
import util.HitBox;
import util.HurtBox;


public class Move {
    private enum BlockType {
        LOW, MID, HIGH
    }

    private int moveLength;

    Animation animation;
    HurtBox[] hurtBoxes;
    HitBox[] hitBoxes;
    boolean[] cancellableFrames;
    int[] damage;
    int[] chipDamage;
    int[] hitStun;
    int[] blockStun;
    BlockType[] blockTypes;

    // FIXME Only using this constructor before refactoring
    public Move(Animation animation, boolean[] cancellableFrames, int[] damage) {
        this.animation = animation;
        this.moveLength = animation.getFrameHoldLength();
        this.cancellableFrames = cancellableFrames;
        this.damage = damage;
    }

    public Move(Animation animation, HurtBox[] hurtBoxes, HitBox[] hitBoxes, boolean[] cancellableFrames, int[] damage) {
        this.animation = animation;
        this.moveLength = animation.getFrameHoldLength();
        this.hurtBoxes = hurtBoxes;
        this.hitBoxes = hitBoxes;
        this.cancellableFrames = cancellableFrames;
        this.damage = damage;
    }

    public Move(Animation animation, HurtBox[] hurtBoxes, HitBox[] hitBoxes, boolean[] cancellableFrames, int[] damage, int[] chipDamage, int[] hitStun, int[] blockStun, BlockType[] blockTypes) {
        this.animation = animation;
        this.moveLength = animation.getFrameHoldLength();
        this.hurtBoxes = hurtBoxes;
        this.hitBoxes = hitBoxes;
        this.cancellableFrames = cancellableFrames;
        this.damage = damage;
        this.chipDamage = chipDamage;
        this.hitStun = hitStun;
        this.blockStun = blockStun;
        this.blockTypes = blockTypes;
    }
}