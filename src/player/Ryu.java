package player;

public class Ryu extends Fighter {
    public Ryu(int x, int y, int w, int h) {
        super("Ryu", x, y, w, h);
        scale = 3.5;

        animator.addAnimation(RyuConstants.IDLE_ANIMATION, "IDLE");
        animator.addAnimation(RyuConstants.CROUCHING_ANIMATION, "CROUCHING");
        animator.addAnimation(RyuConstants.WALKFORWARD_ANIMATION, "WALKFORWARD");
        animator.addAnimation(RyuConstants.WALKBACKWARD_ANIMATION, "WALKBACKWARD");
        animator.addAnimation(RyuConstants.LIGHTATTACK_ANIMATION, "LIGHTATTACK");
        animator.addAnimation(RyuConstants.MEDIUMATTACK_ANIMATION, "MEDIUMATTACK");
        animator.addAnimation(RyuConstants.HEAVYATTACK_ANIMATION, "HEAVYATTACK");

    }
}