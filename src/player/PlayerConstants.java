package player;

import window.WindowConstants;

import java.awt.*;

public class PlayerConstants {

    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 250;

    //200px per second
    public static final double PLAYER_SPEED = 200.0;

    public static final double FLOOR = WindowConstants.SCREEN_HEIGHT - (WindowConstants.SCREEN_HEIGHT * .10);

    public static final double PLAYER1_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .75) - PLAYER_WIDTH;
    public static final double PLAYER2_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .25);


    public static final double PLAYER_START_Y = WindowConstants.SCREEN_HEIGHT - (WindowConstants.SCREEN_HEIGHT * .40);




    public static final Color characterColor = new Color(0,255,0,90);

}
