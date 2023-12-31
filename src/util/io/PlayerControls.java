package util.io;

import java.awt.event.KeyEvent;

public class PlayerControls {
    public KL keyListener = KL.getKeyListener();

    public int JUMP;
    public int LEFT;
    public int CROUCH;
    public int RIGHT;

    public int L_ATTACK;
    public int M_ATTACK;
    public int H_ATTACK;

    public int S_ATTACK;


    public PlayerControls(int playerNum) {
        switch (playerNum) {
            case 1:
                JUMP = KeyEvent.VK_W;
                LEFT = KeyEvent.VK_A;
                CROUCH = KeyEvent.VK_S;
                RIGHT = KeyEvent.VK_D;

                L_ATTACK = KeyEvent.VK_J;
                M_ATTACK = KeyEvent.VK_K;
                H_ATTACK = KeyEvent.VK_L;
                S_ATTACK = KeyEvent.VK_SEMICOLON;

                break;
            case 2:
                JUMP = KeyEvent.VK_UP;
                LEFT = KeyEvent.VK_LEFT;
                CROUCH = KeyEvent.VK_DOWN;
                RIGHT = KeyEvent.VK_RIGHT;

                L_ATTACK = KeyEvent.VK_U;
                M_ATTACK = KeyEvent.VK_I;
                H_ATTACK = KeyEvent.VK_O;
                S_ATTACK = KeyEvent.VK_P;
                break;

        }
    }
}
