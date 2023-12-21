package window.ui;

import window.WindowConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UI {

    private ImageIcon healthBarEmpty;
    private ImageIcon healthBar;
    private int scale = 3;
    private int xOffset = 14;
    private ImageIcon[][] currTimer = new ImageIcon[2][10];
    private int timerIndex1;
    private int timerIndex2;
    private double gameSecond;
    public boolean timedOut;

    public double p1Health;
    public double p2Health;

    public UI() {
        this.init();
        try {
            BufferedImage uiImg = ImageIO.read(new File("./src/images/ui.png"));
            this.healthBarEmpty = new ImageIcon(uiImg.getSubimage(16,1,322,15));
            this.healthBar = new ImageIcon(uiImg.getSubimage(16,16,322,15));
            for (int i = 0;i<10;i++) {
                this.currTimer[0][i] = new ImageIcon(uiImg.getSubimage(16*(i+1),32,12,14));
                this.currTimer[1][i] = new ImageIcon(uiImg.getSubimage(16*(i+1),32,12,14));
            }

        } catch(Exception e) {}
    }

    public void init() {
        this.timerIndex1 = 9;
        this.timerIndex2 = 9;
        this.gameSecond = 0;
        this.timedOut = false;
    }

    public void update(double deltaTime) {
        gameSecond += deltaTime;

        if (gameSecond >= 1.0) {        // Traditionally should be 15 seconds per 1 in game second
            if (timerIndex1 == 0 && timerIndex2 == 0) {
                timedOut = true;
            } else if (timerIndex2 == 0) {
                timerIndex1 -= 1;
                timerIndex2 = 9;
            } else {
                timerIndex2 -= 1;
            }
            gameSecond = 0;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(healthBarEmpty.getImage(), WindowConstants.SCREEN_WIDTH/2 - (healthBarEmpty.getImage().getWidth(null)*scale)/2, 50, healthBarEmpty.getImage().getWidth(null)*scale,healthBarEmpty.getImage().getHeight(null)*scale,null);
        g.drawImage(healthBar.getImage(), WindowConstants.SCREEN_WIDTH/2 - (healthBar.getImage().getWidth(null)*scale)/2, 50, healthBar.getImage().getWidth(null)*scale,healthBar.getImage().getHeight(null)*scale,null);

        g.drawImage(this.currTimer[0][timerIndex1].getImage(), (WindowConstants.SCREEN_WIDTH/2 - (this.currTimer[0][timerIndex1].getImage().getWidth(null)*scale)/2) - xOffset*scale/2, 100, this.currTimer[0][timerIndex1].getImage().getWidth(null)*scale,this.currTimer[0][timerIndex1].getImage().getHeight(null)*scale,null);
        g.drawImage(this.currTimer[1][timerIndex2].getImage(), xOffset*scale / 2 + (WindowConstants.SCREEN_WIDTH/2 - (this.currTimer[1][timerIndex2].getImage().getWidth(null)*scale)/2), 100, this.currTimer[1][timerIndex2].getImage().getWidth(null)*scale,this.currTimer[1][timerIndex2].getImage().getHeight(null)*scale,null);

    }
}
