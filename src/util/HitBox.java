package util;

import java.awt.*;

public class HitBox extends Rect {

    public HitBox(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }

    public boolean overlaps(Rect hurtbox)
    {
        return (this.x     <= hurtbox.x + hurtbox.w) &&
                (this.x + this.w >= hurtbox.x) &&
                (this.y     <= hurtbox.y + hurtbox.h) &&
                (this.y + this.h >= hurtbox.y);
    }

}
