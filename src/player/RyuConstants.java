package player;

import component.Animation;
import util.HitBox;
import util.HurtBox;
import util.Rect;

public class RyuConstants {
    public static final double MAX_HEALTH = 100;

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

    public final static int[] IDLE_FRAMEHOLD = {3,3,2,2,2,2,2,3,3};

    public final static Animation IDLE_ANIMATION = new Animation(
            IDLE_PATH, IDLE_SPRITES, IDLE_HURTBOXES, IDLE_FRAMEHOLD
    );

    public final static String CROUCHING_PATH = "./src/images/Ryu/ryu_crouching.png";

    public final static Rect[] CROUCHING_SPRITES = {
            new Rect(0,0,63,89),
            new Rect(67,17,62,72),
            new Rect(133,24,62,65)
    };

    public final static HurtBox[] CROUCHING_HURTBOXES = {
            new HurtBox(0,0,62,65),
            new HurtBox(0,0,62,65),
            new HurtBox(0,0,62,65)
    };
    public final static Animation CROUCHING_ANIMATION = new Animation(
            CROUCHING_PATH, CROUCHING_SPRITES, CROUCHING_HURTBOXES
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
    public final static String CROUCHATTACK_PATH = "./src/images/Ryu/ryu_crouch_attacks.png";
    public final static Rect[] LIGHTATTACK_SPRITES = {
            new Rect(0,18,74,94),
            new Rect(78,17,102,95),
            new Rect(184,18,74,94)
    };

    public final static HurtBox[] LIGHTATTACK_HURTBOXES = {
            new HurtBox(0,0,74,94),
            new HurtBox(0,0,102,95),
            new HurtBox(0,0,74,94)
    };

    public final static HitBox[] LIGHTATTACK_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(80, -210, 54, 17),
            new HitBox(0, 0, 0, 0)
    };

    public final static int[] LIGHTATTACK_FRAMEHOLD = {3,4,1};

    public final static Animation LIGHTATTACK_ANIMATION = new Animation(
            ATTACK_PATH, LIGHTATTACK_SPRITES, LIGHTATTACK_HURTBOXES, LIGHTATTACK_HITBOXES, LIGHTATTACK_FRAMEHOLD
    );

    // FIXME Need to decouple hit/hurtboxes from Animation
    public final static Move LIGHTATTACK = new Move(
            LIGHTATTACK_ANIMATION,
            LIGHTATTACK_HURTBOXES,
            LIGHTATTACK_HITBOXES,
            new boolean[]{false,false,false},
            new int[]{0,10,0});

    public final static Rect[] CROUCHLIGHTATTACK_SPRITES = {
            new Rect(0,61,72,66),
            new Rect(76,61,99,66),
            new Rect(179,61,72,66)
    };

    public final static HurtBox[] CROUCHLIGHTATTACK_HURTBOXES = {
            new HurtBox(0,0,72,66),
            new HurtBox(0,0,199,66),
            new HurtBox(0,0,72,66)
    };

    public final static HitBox[] CROUCHLIGHTATTACK_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(80, -210, 54, 17),
            new HitBox(0, 0, 0, 0)
    };

    public final static int[] CROUCHLIGHTATTACK_FRAMEHOLD = {3,4,1};

    public final static Animation CROUCHLIGHTATTACK_ANIMATION = new Animation(
            CROUCHATTACK_PATH, CROUCHLIGHTATTACK_SPRITES, CROUCHLIGHTATTACK_HURTBOXES, CROUCHLIGHTATTACK_HITBOXES, CROUCHLIGHTATTACK_FRAMEHOLD
    );

    public final static Rect[] MEDIUMATTACK_SPRITES = {
            new Rect(263,18,68,94),
            new Rect(335,18,90,94),
            new Rect(429,0,80,112),
            new Rect(513,18,90,94)
    };

    public final static HurtBox[] MEDIUMATTACK_HURTBOXES = {
            new HurtBox(0,0,68,94),
            new HurtBox(0,0,90,94),
            new HurtBox(0,0,80,112),
            new HurtBox(0,0,90,94)
    };

    public final static HitBox[] MEDIUMATTACK_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(90, -166, 38, 33),
            new HitBox(87, -188, 35, 54),
            new HitBox(0,0,0,0)
    };

    public final static int[] MEDIUMATTACK_FRAMEHOLD = {3,3,6,3};

    public final static Animation MEDIUMATTACK_ANIMATION = new Animation(
            ATTACK_PATH, MEDIUMATTACK_SPRITES, MEDIUMATTACK_HURTBOXES, MEDIUMATTACK_HITBOXES, MEDIUMATTACK_FRAMEHOLD
    );

    public final static Rect[] CROUCHMEDIUMATTACK_SPRITES = {
            new Rect(274,132,76,65),
            new Rect(354,138,93,59),
            new Rect(451,144,135,53),
            new Rect(590,132,76,65)
    };

    public final static HurtBox[] CROUCHMEDIUMATTACK_HURTBOXES = {
            new HurtBox(0,0,76,65),
            new HurtBox(0,0,93,59),
            new HurtBox(0,0,135,53),
            new HurtBox(0,0,76,65)
    };

    public final static HitBox[] CROUCHMEDIUMATTACK_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(90, -166, 38, 33),
            new HitBox(87, -188, 35, 54),
            new HitBox(0,0,0,0)
    };

    public final static int[] CROUCHMEDIUMATTACK_FRAMEHOLD = {3,3,6,3};

    public final static Animation CROUCHMEDIUMATTACK_ANIMATION = new Animation(
            CROUCHATTACK_PATH, CROUCHMEDIUMATTACK_SPRITES, CROUCHMEDIUMATTACK_HURTBOXES, CROUCHMEDIUMATTACK_HITBOXES, CROUCHMEDIUMATTACK_FRAMEHOLD
    );

    public final static Rect[] HEAVYATTACK_SPRITES = {
            new Rect(607,18,68,94),
            new Rect(680,18,74,94),
            new Rect(758,21,77,91),
            new Rect(839,21,112,91),
            new Rect(955,21,77,91),
            new Rect(1036,18,68,94)
    };

    public final static HurtBox[] HEAVYATTACK_HURTBOXES = {
            new HurtBox(0,0,68,94),
            new HurtBox(0,0,74,94),
            new HurtBox(0,0,77,91),
            new HurtBox(0,0,112,91),
            new HurtBox(0,0,77,91),
            new HurtBox(0,0,68,94)
    };

    public final static HitBox[] HEAVYATTACK_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0),
            new HitBox(86, -193, 64, 17),
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0)

    };

    public final static int[] HEAVYATTACK_FRAMEHOLD = {3,3,2,6,2,2};

    public final static Animation HEAVYATTACK_ANIMATION = new Animation(
            ATTACK_PATH, HEAVYATTACK_SPRITES, HEAVYATTACK_HURTBOXES, HEAVYATTACK_HITBOXES, HEAVYATTACK_FRAMEHOLD
    );

    public final static Rect[] CROUCHHEAVYATTACK_SPRITES = {
            new Rect(565,53,67,74),
            new Rect(636,36,83,91),
            new Rect(723,0,60,127),
            new Rect(787,36,83,91),
            new Rect(874,53,67,74)
    };

    public final static HurtBox[] CROUCHHEAVYATTACK_HURTBOXES = {
            new HurtBox(0,0,67,74),
            new HurtBox(0,0,83,91),
            new HurtBox(0,0,60,127),
            new HurtBox(0,0,83,91),
            new HurtBox(0,0,67,74)
    };

    public final static HitBox[] CROUCHHEAVYATTACK_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0),
            new HitBox(86, -193, 64, 17),
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0)

    };

    public final static int[] CROUCHHEAVYATTACK_FRAMEHOLD = {3,3,2,6,2};

    public final static Animation CROUCHHEAVYATTACK_ANIMATION = new Animation(
            CROUCHATTACK_PATH, CROUCHHEAVYATTACK_SPRITES, CROUCHHEAVYATTACK_HURTBOXES, CROUCHHEAVYATTACK_HITBOXES, CROUCHHEAVYATTACK_FRAMEHOLD
    );

    public final static Rect[] SWEEP_SPRITES = {
            new Rect(671,132,76,65),
            new Rect(751,135,55,62),
            new Rect(810,137,119,60),
            new Rect(933,139,64,58),
            new Rect(1001,135,65,62),
            new Rect(1070,133,60,64)
    };

    public final static HurtBox[] SWEEP_HURTBOXES = {
            new HurtBox(0,0,76,65),
            new HurtBox(0,0,55,62),
            new HurtBox(0,0,119,60),
            new HurtBox(0,0,64,58),
            new HurtBox(0,0,65,62),
            new HurtBox(0,0,60,64)
    };

    public final static HitBox[] SWEEP_HITBOXES = {
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0),
            new HitBox(86, -193, 64, 17),
            new HitBox(0,0,0,0),
            new HitBox(0,0,0,0)

    };

    public final static int[] SWEEP_FRAMEHOLD = {3,3,2,6,2,2};

    public final static Animation SWEEP_ANIMATION = new Animation(
            CROUCHATTACK_PATH, SWEEP_SPRITES, SWEEP_HURTBOXES, SWEEP_HITBOXES, SWEEP_FRAMEHOLD
    );


}
