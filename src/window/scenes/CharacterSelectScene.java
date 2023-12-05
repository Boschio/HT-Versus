package window.scenes;

import window.WindowConstants;

import java.awt.*;

public class CharacterSelectScene extends Scene {
    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);
        g.setColor(Color.RED);
        g.drawString("SELECT YOUR CHARACTER",10, (int) (WindowConstants.INSET_SIZE*1.5));
    }
}
