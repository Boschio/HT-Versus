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
    static Animation[] L_ATTACK_ANIMATIONS = {
            RyuConstants.L_ATTACK_ANIMATION
    };
    static Animation[] M_ATTACK_ANIMATIONS = {
            RyuConstants.M_ATTACK_ANIMATION
    };
    static Animation[] H_ATTACK_ANIMATIONS = {
            RyuConstants.H_ATTACK_ANIMATION
    };
    static Animation[] CROUCH_L_ATTACK_ANIMATIONS = {
            RyuConstants.CROUCH_L_ATTACK_ANIMATION
    };
    static Animation[] CROUCH_M_ATTACK_ANIMATIONS = {
            RyuConstants.CROUCH_M_ATTACK_ANIMATION
    };
    static Animation[] CROUCH_H_ATTACK_ANIMATIONS = {
            RyuConstants.CROUCH_H_ATTACK_ANIMATION
    };
    static Animation[] SWEEP_ANIMATIONS = {
            RyuConstants.SWEEP_ANIMATION
    };

    static Animation[] SHORYUKEN_ANIMATIONS = {
            RyuConstants.SHORYUKEN_ANIMATION
    };


    static Move[] L_ATTACKS = {
            RyuConstants.L_ATTACK
    };
    static Move[] M_ATTACKS = {
            RyuConstants.M_ATTACK
    };
    static Move[] H_ATTACKS = {
            RyuConstants.H_ATTACK
    };
    static Move[] CROUCH_L_ATTACKS = {
            RyuConstants.CROUCH_L_ATTACK
    };
    static Move[] CROUCH_M_ATTACKS = {
            RyuConstants.CROUCH_M_ATTACK
    };
    static Move[] CROUCH_H_ATTACKS = {
            RyuConstants.CROUCH_H_ATTACK
    };
    static Move[] SWEEPS = {
            RyuConstants.SWEEP
    };

    static Move[] SHORYUKENS = {
            RyuConstants.SHORYUKEN
    };

    public static final double FLOOR = WindowConstants.SCREEN_HEIGHT - (WindowConstants.SCREEN_HEIGHT * .10);

    public static final double PLAYER1_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .75) - PLAYER_WIDTH;
    public static final double PLAYER2_START_X = WindowConstants.SCREEN_WIDTH - (WindowConstants.SCREEN_WIDTH * .25);

    public static final double PLAYER_START_Y = FLOOR;




    public static final Color characterColor = new Color(0,255,0,90);

}
