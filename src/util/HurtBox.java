package util;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class HurtBox extends Rect {

    public HurtBox(int x, int y, int w, int h) {
        super(x, y, w, h, Color.GREEN);
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

}
