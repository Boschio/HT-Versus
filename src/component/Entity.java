package component;

import java.awt.Color;
import java.awt.Graphics;

public class Entity {

    public double x;
    public double y;
    public double w;
    public double h;

    public double vx = 0;
    public double vy = 0;

    public double ay = G; // acceleration

    static final double G = 0.4; // Gravity

    Color c = Color.BLACK;

    public static double scale = 2;

    public Entity(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        // Need to make sure h and w are not negative
        this.w = w;
        this.h = h;
    }

    public Entity(int x, int y, int w, int h, Color c) {
        this(x, y, w, h);
        setColor(c);
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public void draw(Graphics g) {
//        this.drawDebug(g);
    }

//    public void drawDebug(Graphics g) {
//        g.setColor(Color.green);
//        g.drawLine((int) (x-8), (int) y, (int) (x+7), (int) y);
//        g.drawLine((int) (x), (int) (y-8), (int) (x), (int) (y+7));
//    }

}
