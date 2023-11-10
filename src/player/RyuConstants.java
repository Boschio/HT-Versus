package player;

import component.Animate;
import component.AnimateTest;
import util.Rect;

import java.util.HashMap;

public class RyuConstants {
    public static final double HEALTH = 100;

//    public static final int IDLE = 0;
//    public static final int WALKFORWARD = 2;
//    public static final int WALKBACKWARD = 3;
//    public static final int JUMP = 5;
//    public static final int FALLING = 6;
//    public static final int LIGHTATTACK = 9;
//
//    public static int GetAnimationFrames(int action) {
//        switch (action) {
//            case IDLE:
//                return 9;
//            case WALKFORWARD:
//                return 6;
//            case WALKBACKWARD:
//                return 6;
//            case JUMP:
//                return 9;
//            case FALLING:
//                return 2;
//            case LIGHTATTACK:
//                return 3;
//            default:
//                return 1;
//        }
//    }

    public final static String IDLE_PATH = "./src/images/Ryu/ryu_idle_walk.png";
    public final static Rect[] IDLE_SPRITES = {
            new Rect(2,7,66,93),
            new Rect(72,7,66,93),
            new Rect(142,6,66,94),
            new Rect(211,4,66,96),
            new Rect(282,3,66,97),
            new Rect(353,2,64,98),
            new Rect(422,2,64,98),
            new Rect(492,4,66,96),
            new Rect(562,6,66,94)
    };

    public final static AnimateTest IDLE_ANIMATION = new AnimateTest(
            IDLE_PATH, IDLE_SPRITES//, -33, -90, 3
    );


    public final static String WALKFORWARD_PATH = "./src/images/Ryu/ryu_idle_walk.png";
    public final static Rect[] WALKFORWARD_SPRITES = {
            new Rect(2,111,63,89),
            new Rect(70,107,70,93),
            new Rect(141,105,68,95),
            new Rect(218,105,59,95),
            new Rect(290,106,54,94),
            new Rect(357,107,56,93)
    };

    public final static AnimateTest WALKFORWARD_ANIMATION = new AnimateTest(
            WALKFORWARD_PATH, WALKFORWARD_SPRITES
    );

    public final static String WALKBACKWARD_PATH = "./src/images/Ryu/ryu_idle_walk.png";
    public final static Rect[] WALKBACKWARD_SPRITES = {
            new Rect(2,211,63,89),
            new Rect(72,207,61,93),
            new Rect(146,206,54,94),
            new Rect(222,205,54,95),
            new Rect(284,205,61,95),
            new Rect(351,207,63,93)
    };

    public final static AnimateTest WALKBACKWARD_ANIMATION = new AnimateTest(
            WALKBACKWARD_PATH, WALKBACKWARD_SPRITES
    );

    public final static String ATTACK_PATH = "./src/images/Ryu/ryu_idle_walk.png";
    public final static Rect[] ATTACK_SPRITES = {
            new Rect(607,18,68,94),
            new Rect(680,18,74,94),
            new Rect(758,21,77,91),
            new Rect(839,21,112,91),
            new Rect(955,21,77,91),
            new Rect(1036,18,68,94)
    };

    public final static AnimateTest ATTACK_ANIMATION = new AnimateTest(
            ATTACK_PATH, ATTACK_SPRITES
    );

}
