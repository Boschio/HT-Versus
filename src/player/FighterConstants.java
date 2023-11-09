package player;

import window.WindowConstants;

import java.awt.*;

public class FighterConstants {

    public static final double PLAYER_WIDTH = 100;
    public static final double PLAYER_HEIGHT = 250;

    //200px per second
    public static final double PLAYER_SPEED = 200.0;

    public static final double SCALE = 2.0;

    public enum direction {
        LEFT,
        RIGHT
    }

    public enum PlayerState {
        IDLE, STANDING, CROUCHING, JUMP_UP, JUMP_FORWARD, JUMP_BACKWARD, WALK_FORWARD, WALK_BACKWARD, ATTACKING
    }

    public static final double FLOOR = WindowConstants.SCREEN_HEIGHT - (WindowConstants.SCREEN_HEIGHT * .10);

    public static final double PLAYER1_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .75) - PLAYER_WIDTH;
    public static final double PLAYER2_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .25);


//    public static final double PLAYER_START_Y = WindowConstants.SCREEN_HEIGHT - (WindowConstants.SCREEN_HEIGHT * .40);
    public static final double PLAYER_START_Y = 397;




    public static final Color characterColor = new Color(0,255,0,90);

}
