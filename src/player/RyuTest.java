package player;

import component.Animate;

public class RyuTest extends Fighter {
    static String[] pose = {"IDLE","LT", "RT", "JUMP"};


    public RyuTest(int x, int y, int w, int h) {
        super("Ryu", pose, x, y, w, h);
        scale = 3.5;

        animator.addAnimation(RyuConstants.IDLE_ANIMATION, "IDLE");
        animator.addAnimation(RyuConstants.WALKFORWARD_ANIMATION, "WALKFORWARD");
        animator.addAnimation(RyuConstants.WALKBACKWARD_ANIMATION, "WALKBACKWARD");
        animator.addAnimation(RyuConstants.ATTACK_ANIMATION, "ATTACK");
    }
}