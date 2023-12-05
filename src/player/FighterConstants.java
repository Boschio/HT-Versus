package player;

import component.Animation;
import window.WindowConstants;

import java.awt.*;

public class FighterConstants {

    public static final double PLAYER_WIDTH = 100;
    public static final double PLAYER_HEIGHT = 250;

    //200px per second
    public static final double PLAYER_SPEED = 200.0;

    public static final double SCALE = 2.0;

    public enum Direction {
        LEFT,
        RIGHT
    }

    public enum Characters {
        Ryu(0), Ken(1);
        final int value;
        Characters(int value) {
            this.value = value;
        }
    }

    static Animation[] IDLE_ANIMATIONS = {
            RyuConstants.IDLE_ANIMATION
    };
    static Animation[] CROUCHING_ANIMATIONS = {
            RyuConstants.CROUCHING_ANIMATION
    };
    static Animation[] WALKBACKWARD_ANIMATIONS = {
            RyuConstants.WALKBACKWARD_ANIMATION
    };
    static Animation[] WALKFORWARD_ANIMATIONS = {
            RyuConstants.WALKFORWARD_ANIMATION
    };
    static Animation[] LIGHTATTACK_ANIMATIONS = {
            RyuConstants.LIGHTATTACK_ANIMATION
    };
    static Animation[] MEDIUMATTACK_ANIMATIONS = {
            RyuConstants.MEDIUMATTACK_ANIMATION
    };
    static Animation[] HEAVYATTACK_ANIMATIONS = {
            RyuConstants.HEAVYATTACK_ANIMATION
    };
    static Animation[] CROUCHLIGHTATTACK_ANIMATIONS = {
            RyuConstants.CROUCHLIGHTATTACK_ANIMATION
    };
    static Animation[] CROUCHMEDIUMATTACK_ANIMATIONS = {
            RyuConstants.CROUCHMEDIUMATTACK_ANIMATION
    };
    static Animation[] CROUCHHEAVYATTACK_ANIMATIONS = {
            RyuConstants.CROUCHHEAVYATTACK_ANIMATION
    };
    static Animation[] SWEEP_ANIMATIONS = {
            RyuConstants.SWEEP_ANIMATION
    };

    public enum PlayerState {
        IDLE, STANDING, CROUCHING, JUMP_UP, JUMP_FORWARD, JUMP_BACKWARD, WALK_FORWARD, WALK_BACKWARD, ATTACKING
    }

    public static final double FLOOR = WindowConstants.SCREEN_HEIGHT - (WindowConstants.SCREEN_HEIGHT * .10);

    public static final double PLAYER1_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .75) - PLAYER_WIDTH;
    public static final double PLAYER2_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .25);

    public static final double PLAYER_START_Y = FLOOR;




    public static final Color characterColor = new Color(0,255,0,90);

}
