package component;

import java.awt.Image;
import java.awt.Toolkit;

public class Animation {

    private Image[] image;
    private int current = 0;

    private int duration;
    private int delay;

    private int start = 0;

    public Animation(String name, int count, int start, int duration, String type) {

        this.start = start;
        this.duration = duration;
        delay = duration;

        image = new Image[count];

        for (int i=0;i<count;i++) {
            image[i] = Toolkit.getDefaultToolkit().getImage("./src/images/Ryu/" + name + "_" + i + type);
        }
    }

    public Image getCurrentImage() {
        delay--;
        if(delay == 0) {
            current++;

            if (current == image.length) {
                current = start;
            }
            delay = duration;
        }

        return image[current];
    }

    public Image getStaticImage() {
        return image[0];
    }

}
