package util;

import player.FighterConstants;

import java.awt.*;

public class HitBox extends Rect {

    public Rect resizer;
    Color HitBoxColor = new Color(255,0,0,57);

    public HitBox(int x, int y, int w, int h) {
        super(x, y, w, h, Color.RED);

        resizer = new Rect(x+w-10, y+h-10, 15, 15, Color.RED);

    }

    public boolean overlaps(Rect hurtbox)
    {
        return (this.x     <= hurtbox.x + hurtbox.w) &&
                (this.x + this.w >= hurtbox.x) &&
                (this.y     <= hurtbox.y + hurtbox.h) &&
                (this.y + this.h >= hurtbox.y);
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public void resizeBy(int dw, int dh) {
        super.resizeBy(dw, dh);

        resizer.moveBy(dw, dh);
    }

    public void moveBy(int dx, int dy) {
        super.moveBy(dx, dy);

        resizer.moveBy(dx, dy);
    }
    public String toString() {
//        return "new HitBox(" + 0 + ", " + 0 + ", " + (int)w/3 + ", " + (int)h/3 + "),";
        return "new HitBox(" + x + ", " + y + ", " + (int)w + ", " + (int)h + "),";

    }

    public String debugString() {
        int originX = (int) -(FighterConstants.PLAYER1_START_X - x - w/2);
        int originY = (int) -(FighterConstants.PLAYER_START_Y-100 - y - h);
        return "new HitBox(" + (int)originX + ", " + (int)originY + ", " + (int)w/3 + ", " + (int)h/3 + "),";
    }

    public void draw(Graphics g) {
        super.draw(g);

        resizer.fillDraw(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(HitBoxColor);
        g2d.fillRect((int) x, (int) y, (int) w, (int) h);
    }
}
