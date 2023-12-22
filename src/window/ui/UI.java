package window.ui;

import util.Rect;
import window.Window;
import window.WindowConstants;
import window.scenes.GameScene;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UI {
    private GameScene gs;
    private ImageIcon healthBarEmpty, playerText, drawGame, timeOver, winText;

    private int scale = 3;
    private int xOffset = 14;
    private ImageIcon[][] currTimer = new ImageIcon[2][10];
    private int timerIndex1;
    private int timerIndex2;
    private double gameSecond;
    public double winCountdown, menuCountdown;
    public boolean timedOut, isDrawGame, roundOver;

    public Rect p1HealthBar, p2HealthBar;
    public int healthBarScaledWidth;
    public int healthBarScaledHeight;

    public UI(GameScene gs) {
        this.gs = gs;
        this.init();
        try {
            BufferedImage uiImg = ImageIO.read(new File("./src/images/ui.png"));
            this.healthBarEmpty = new ImageIcon(uiImg.getSubimage(16,1,322,15));
            this.healthBarEmpty = new ImageIcon(uiImg.getSubimage(16,1,322,15));

            this.playerText = new ImageIcon(uiImg.getSubimage(353,88,62,14));
            this.drawGame = new ImageIcon(uiImg.getSubimage(427,114,59,26));
            this.timeOver = new ImageIcon(uiImg.getSubimage(352,112,64,30));
            this.winText = new ImageIcon(uiImg.getSubimage(352,146,40,10));

            for (int i = 0;i<10;i++) {
                this.currTimer[0][i] = new ImageIcon(uiImg.getSubimage(16*(i+1),32,12,14));
                this.currTimer[1][i] = new ImageIcon(uiImg.getSubimage(16*(i+1),32,12,14));
            }
            this.p1HealthBar = new Rect(17,19,144,9);
            this.p2HealthBar = new Rect(193,19,144,9);
            healthBarScaledWidth = (int) (p1HealthBar.w*scale);
            healthBarScaledHeight = (int) (p1HealthBar.h*scale);
        } catch(Exception e) {}
    }

    public void init() {
        this.timerIndex1 = 9;
        this.timerIndex2 = 9;
        this.gameSecond = 0;
        this.winCountdown = 1.0;
        this.menuCountdown = 5.0;
        this.roundOver = false;
        this.timedOut = false;
        this.isDrawGame = false;
    }

    public void update(double deltaTime) {
        gameSecond += deltaTime;

        p1HealthBar.setW((gs.p1.currHealth*(healthBarScaledWidth/scale)/gs.p1.maxHealth));
        p2HealthBar.setW((gs.p2.currHealth*(healthBarScaledWidth/scale)/gs.p2.maxHealth));

        if (gameSecond >= 1.0 && !roundOver) {        // Traditionally should be 15 seconds per 1 in game second
            if (timerIndex1 == 0 && timerIndex2 == 0) {
                timedOut = true;
                roundOver = true;
            } else if (timerIndex2 == 0) {
                timerIndex1 -= 1;
                timerIndex2 = 9;
            } else {
                timerIndex2 -= 1;
            }
            gameSecond = 0;
        }

        if (roundOver) {
            winCountdown -= deltaTime;
            menuCountdown -= deltaTime;
            if (gs.p1.currHealth > gs.p2.currHealth) {
                // p1 win
                gs.p1Win = true;
            } else if (gs.p2.currHealth > gs.p1.currHealth) {
                // p2 win
                gs.p2Win = true;
            } else {
                // draw
                isDrawGame = true;
            }
        }
    }

    public void draw(Graphics g) {
        g.drawImage(healthBarEmpty.getImage(), WindowConstants.SCREEN_WIDTH/2 - (healthBarEmpty.getIconWidth()*scale)/2, 50, healthBarEmpty.getIconWidth()*scale,healthBarEmpty.getIconHeight()*scale,null);
        g.fillRect((int) (WindowConstants.SCREEN_WIDTH/2 - (p1HealthBar.w*scale) - 48), 62, (int) p1HealthBar.w*scale, healthBarScaledHeight);
        g.fillRect(WindowConstants.SCREEN_WIDTH/2 + 48, 62, (int) p2HealthBar.w*scale, healthBarScaledHeight);

        g.drawImage(this.currTimer[0][timerIndex1].getImage(), (WindowConstants.SCREEN_WIDTH/2 - (this.currTimer[0][timerIndex1].getIconWidth()*scale)/2) - xOffset*scale/2, 100, this.currTimer[0][timerIndex1].getIconWidth()*scale,this.currTimer[0][timerIndex1].getIconHeight()*scale,null);
        g.drawImage(this.currTimer[1][timerIndex2].getImage(), xOffset*scale / 2 + (WindowConstants.SCREEN_WIDTH/2 - (this.currTimer[1][timerIndex2].getIconWidth()*scale)/2), 100, this.currTimer[1][timerIndex2].getIconWidth()*scale,this.currTimer[1][timerIndex2].getIconHeight()*scale,null);

        if (timedOut) {
            g.drawImage(this.timeOver.getImage(), WindowConstants.SCREEN_WIDTH / 2 - timeOver.getIconWidth() * scale / 2, WindowConstants.SCREEN_HEIGHT / 2 - this.timeOver.getIconHeight() * scale * 2, this.timeOver.getIconWidth() * scale, this.timeOver.getIconHeight() * scale, null);
        }
        if(roundOver && this.winCountdown <= 0.0) {
            if (isDrawGame) {
                g.drawImage(this.drawGame.getImage(), WindowConstants.SCREEN_WIDTH/2 - drawGame.getIconWidth()*scale/2, WindowConstants.SCREEN_HEIGHT/2, this.drawGame.getIconWidth()*scale, this.drawGame.getIconHeight()*scale, null);
            } else {
                g.drawImage(this.playerText.getImage(), WindowConstants.SCREEN_WIDTH/2 - playerText.getIconWidth()*scale/2 - this.currTimer[0][1].getIconWidth()*scale/2, WindowConstants.SCREEN_HEIGHT/2, this.playerText.getIconWidth()*scale, this.playerText.getIconHeight()*scale, null);
                g.drawImage(this.winText.getImage(), WindowConstants.SCREEN_WIDTH/2 - winText.getIconWidth()*scale/2, WindowConstants.SCREEN_HEIGHT/2 + playerText.getIconHeight()*scale + 25, this.winText.getIconWidth()*scale, this.winText.getIconHeight()*scale, null);
                if (gs.p1Win) {
                    g.drawImage(this.currTimer[0][1].getImage(), WindowConstants.SCREEN_WIDTH/2 - this.currTimer[0][1].getIconWidth()*scale/2 + this.currTimer[0][1].getIconWidth()*scale*3, WindowConstants.SCREEN_HEIGHT/2, this.currTimer[0][1].getIconWidth()*scale, this.currTimer[0][1].getIconHeight()*scale, null);
                } else {
                    g.drawImage(this.currTimer[0][2].getImage(), WindowConstants.SCREEN_WIDTH/2 - this.currTimer[0][2].getIconWidth()*scale/2 + this.currTimer[0][2].getIconWidth()*scale*3, WindowConstants.SCREEN_HEIGHT/2, this.currTimer[0][2].getIconWidth()*scale, this.currTimer[0][2].getIconHeight()*scale, null);
                }
            }
        }
    }
}
