package component;

import player.Fighter;
import util.Rect;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Sprite extends Rect {

    public Animation[] animation;

    public final static int IDLE = 0;
    public final static int LT = 1;
    public final static int RT = 2;
    public final static int LIGHT_ATTACK = 3;

    public int pose = IDLE;

    public static double scale = 1;

    public boolean isMoving = false;

    public Sprite(String name, String[] pose, int imageCount, int start, String fileType, int x, int y, int w, int h) {
        super(x, y, w, h);

        animation = new Animation[pose.length];

        for(int i = 0;i<pose.length;i++) {
            animation[i] = new Animation(name + "_" + pose[i], imageCount, start, 10, fileType);
        }
    }

    public void goLT(int dx)
    {
        pose = LT;
        isMoving = true;
        vx = -dx;
    }

    public void goRT(int dx)
    {
        pose = RT;
        isMoving = true;
        vx = dx;
    }

    public void draw(Graphics g) {
        Image temp;

        if (!isMoving) {
            temp = animation[pose].getStaticImage();
        } else {
            temp = animation[pose].getCurrentImage();
        }

        w = scale * temp.getWidth(null);
        h = scale * temp.getHeight(null);

        g.drawImage(temp, (int)x, (int)y, (int)w, (int)h, null);
        g.setColor(Color.red);
        g.drawRect((int)x, (int)y, (int)w, (int)h);
    }

}
