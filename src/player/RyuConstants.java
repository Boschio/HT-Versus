package player;

import component.Animation;
import util.HurtBox;
import util.Rect;

public class RyuConstants {
    public static final double HEALTH = 100;

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

    public final static HurtBox[] IDLE_HURTBOXES = {
            new HurtBox(0,0,55, 93),
            new HurtBox(0,0,55, 93),
            new HurtBox(0,0,56, 94),
            new HurtBox(0,0,56,96),
            new HurtBox(0,0,56,96),
            new HurtBox(0,0,56,98),
            new HurtBox(0,0,56,98),
            new HurtBox(0,0,57,96),
            new HurtBox(0,0,58,94)
    };

    public final static Animation IDLE_ANIMATION = new Animation(
            IDLE_PATH, IDLE_SPRITES, IDLE_HURTBOXES//, -33, -90, 3
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

    public final static Animation WALKFORWARD_ANIMATION = new Animation(
            WALKFORWARD_PATH, WALKFORWARD_SPRITES, IDLE_HURTBOXES
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

    public final static Animation WALKBACKWARD_ANIMATION = new Animation(
            WALKBACKWARD_PATH, WALKBACKWARD_SPRITES, IDLE_HURTBOXES
    );

    public final static String ATTACK_PATH = "./src/images/Ryu/ryu_punch.png";
    public final static Rect[] LIGHTATTACK_SPRITES = {
            new Rect(0,18,74,94),
            new Rect(78,17,102,95),
            new Rect(184,18,74,94)
    };

    public final static Rect[] MEDIUMATTACK_SPRITES = {
            new Rect(263,18,68,94),
            new Rect(335,18,90,94),
            new Rect(429,0,80,112),
            new Rect(513,18,90,94)
    };

    public final static Rect[] HEAVYATTACK_SPRITES = {
            new Rect(607,18,68,94),
            new Rect(680,18,74,94),
            new Rect(758,21,77,91),
            new Rect(839,21,112,91),
            new Rect(955,21,77,91),
            new Rect(1036,18,68,94)
    };

    public final static Animation LIGHTATTACK_ANIMATION = new Animation(
            ATTACK_PATH, LIGHTATTACK_SPRITES, IDLE_HURTBOXES
    );
    public final static Animation MEDIUMATTACK_ANIMATION = new Animation(
            ATTACK_PATH, MEDIUMATTACK_SPRITES, IDLE_HURTBOXES
    );
    public final static Animation HEAVYATTACK_ANIMATION = new Animation(
            ATTACK_PATH, HEAVYATTACK_SPRITES, IDLE_HURTBOXES
    );


}
