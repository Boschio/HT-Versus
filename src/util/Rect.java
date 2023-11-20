package util;

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
    public double x;
    public double y;
    public double w;
    public double h;

    public double vx = 0;
    public double vy = 0;

    public double ay = G; // acceleration

    static final double G = 0.4; // Gravity

    Color c = Color.BLACK;

    public boolean held = false;

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

    public void grab() {
        held = true;
    }

    public void drop() {
        held = false;
    }

    public void resizeBy(int dw, int dh) {
        w += dw;
        h += dh;
    }

    public void moveBy(int dx, int dy)
    {
        x += dx;
        y += dy;
    }


    public void move() {
        x += vx;
        y += vy;

        vy += ay;
    }

    public void jump(int dy) {
        vy -= dy;
    }

    public void bounceOff(Rect r) {
        if (wasAbove(r) || wasBelow(r)) {
            bounceV();
        }

        if (wasLeftOf(r) || wasRightOf(r)) {
            bounceH();
        }
    }

    public void bounceV() {
        vy = -vy * (.6);
        if (Math.abs(vy) < 3)
            vy = 0;
    }

    public void bounceH() {
        vx = -vx * (.6);
        if (Math.abs(vx) < 3)
            vx = 0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void goLT(int dx) {
        vx = -dx;
    }

    public void goRT(int dx) {
        vx = dx;
    }

    public void goUP(int dy) {
        vy = -dy;
    }

    public void goDN(int dy) {
        vy = dy;
    }

    public void physicsOFF() {
        setVelocity(0, 0);
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public boolean contains(int mx, int my) {
        return ((mx >= x) && (mx <= x + w) && (my >= y) && (my <= y + h));
    }

    public boolean isLeftOf(Rect r) {
        return x - 1 < r.x - w;
    }

    public boolean isRightOf(Rect r) {
        return x + 1 > r.x + r.w;
    }

    public boolean isAbove(Rect r) {
        return y - 1 < r.y - h;
    }

    public boolean isBelow(Rect r) {
        return y + 1 > r.y + r.h;
    }

    public void chase(Rect r) {
        if (r.isAbove(this)) goUP(4);
        if (r.isBelow(this)) goDN(4);
        if (r.isLeftOf(this)) goLT(4);
        if (r.isRightOf(this)) goRT(4);
    }

    public boolean wasLeftOf(Rect r) {
        return x - vx < r.x - w + 1;
    }

    public boolean wasRightOf(Rect r) {
        return x - vx > r.x + r.w - 1;
    }

    public boolean wasAbove(Rect r) {
        return y - vy < r.y - h + 1;
    }

    public boolean wasBelow(Rect r) {
        return y - vy > r.y + r.h - 1;
    }

    public void pushedOutOf(Rect r) {
        if (wasLeftOf(r))
            pushLeftOf(r);
        if (wasRightOf(r))
            pushRightOf(r);
        if (wasAbove(r))
            pushAbove(r);
        if (wasBelow(r))
            pushBelow(r);
    }

    public void pushLeftOf(Rect r) {
        x = r.x - w - 1;
    }

    public void pushRightOf(Rect r) {
        x = r.x + r.w + 1;
    }

    public void pushAbove(Rect r) {
        y = r.y - h - 1;
    }

    public void pushBelow(Rect r) {
        y = r.y + r.h + 1;
    }

    public void applyFrictionWithFloor() {
//		vx = 0;
        vx = vx * .6;
    }

    public void stopFalling() {
        vy = 0;
    }

    public boolean standingOnAny(Rect[] r) {
        for (int i = 0; i < r.length; i++) {
            if (y + h == r[i].y - 1) {
                return true;
            }
        }
        return false;
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
