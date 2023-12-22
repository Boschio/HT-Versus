package window.stage;

import window.WindowConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Stage {
    ImageIcon bgBack;
    ImageIcon bgFront;

    int scale = 3;
    int xOffset;

    public Stage(String stage) {

        try {
            BufferedImage imgBack  = ImageIO.read(new File("./src/assets/images/stage/" + stage + "-stage-back.png"));
            BufferedImage imgFront  = ImageIO.read(new File("./src/assets/images/stage/" + stage + "-stage-front.png"));
            this.bgBack = new ImageIcon(imgBack);
            this.bgFront = new ImageIcon(imgFront);
        } catch(Exception e) {}

        xOffset = 0;
    }

    public void setBGOffset(int x) {
        this.xOffset = x;
    }

    public void update(double deltaTime) {
        System.out.println("xOffset: " + xOffset);
        System.out.println("bgFront x: " + (xOffset - (bgFront.getImage().getWidth(null) * scale) - WindowConstants.SCREEN_WIDTH/2));
    }

    public void draw(Graphics g) {
        g.drawImage(bgBack.getImage(), (int)(xOffset/4) - (bgBack.getImage().getWidth(null) * scale/2) + WindowConstants.SCREEN_WIDTH/2, (int)0, bgBack.getImage().getWidth(null) * scale, bgBack.getImage().getHeight(null) * scale, null);
        g.drawImage(bgFront.getImage(), (int)(xOffset*1.5) - ((bgFront.getImage().getWidth(null) * scale)/2) + WindowConstants.SCREEN_WIDTH/2, (int)this.bgFront.getIconHeight(), bgFront.getImage().getWidth(null) * scale, bgFront.getImage().getHeight(null) * scale, null);
    }

}
