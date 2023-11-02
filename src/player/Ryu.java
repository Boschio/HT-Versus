package player;

import component.Sprite;

public class Ryu extends Fighter {

    static String[] pose = {"IDLE","LT", "RT"};

    public Ryu(int x, int y, int w, int h) {
        super("Ryu", pose, 6, 0, ".png", x, y, w, h);
        scale = 3.5;
    }

}
