package util;

import java.awt.*;

public class HurtBox extends Rect {

    public Rect resizer;
    Color HurtBoxColor = new Color(0,255,0,57);

    public HurtBox(int x, int y, int w, int h) {
        super(x, y, w, h, Color.GREEN);

        resizer = new Rect(x+w-10, y+h-10, 15, 15, Color.GREEN);
    }

    public boolean overlaps(Rect hitbox)
    {
        return (this.x     <= hitbox.x + hitbox.w) &&
                (this.x + this.w >= hitbox.x) &&
                (this.y     <= hitbox.y + hitbox.h) &&
                (this.y + this.h >= hitbox.y);
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
        return "new HurtBox(" + x + ", " + y + ", " + w + ", " + h + ");";
    }

    public void draw(Graphics g) {
        super.draw(g);

		resizer.fillDraw(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(HurtBoxColor);
        g2d.fillRect((int) x, (int) y, (int) w, (int) h);
    }

}
