package util;

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
    public double x;
    public double y;
    public double w;
    public double h;

    Color c = Color.BLACK;

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        // Need to make sure h and w are not negative
        this.w = w;
        this.h = h;
    }

    public Rect(int x, int y, int w, int h, Color c) {
        this(x, y, w, h);
        setColor(c);
    }

    public void resizeBy(int dw, int dh) {
        w += dw;
        h += dh;
    }

    public void moveBy(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setH(double h) {
        this.h = h;
    }



    public void setColor(Color c) {
        this.c = c;
    }


    public boolean overlaps(Rect r) {
        return ((this.x <= r.x + r.w) &&
                (this.x + this.w >= r.x) &&
                (this.y <= r.y + r.h) &&
                (this.y + this.h >= r.y));
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.drawRect((int) x, (int) y, (int) w, (int) h);
    }

    public void fillDraw(Graphics g) {
        g.setColor(c);
        g.fillRect((int) x, (int) y, (int) w, (int) h);
    }

}
