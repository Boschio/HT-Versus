package window.scenes;

import util.Rect;
import util.io.KL;
import util.io.ML;
import window.Window;
import window.WindowConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuScene extends Scene{

    private ML mouseListener;
    private int scale = 3;
    boolean hoveringOverPlay, hoveringOverQuit;

    private BufferedImage bg, hero, ui;
    private ImageIcon cursor, play;

    private Rect playRect, quitRect;

    private ImageIcon[] alphabet = new ImageIcon[32];
    private ImageIcon[] quit = new ImageIcon[4];

    int offset = 12;

    public MenuScene() {
        try {
            bg = ImageIO.read(new File("./src/images/Menu/menu-bg.png"));
            hero = ImageIO.read(new File("./src/images/Menu/HeroImage.png"));
            ui = ImageIO.read(new File("./src/images/ui.png"));

            cursor = new ImageIcon(ui.getSubimage(344,16,16,16));

            play = new ImageIcon(ui.getSubimage(16,168,63,18));

            for (int i = 0;i<2;i++) {
                for (int j = 0;j<16;j++) {
                    this.alphabet[(alphabet.length/2*i)+j] = new ImageIcon(ui.getSubimage(16 + (offset*j),113+(offset*i),12,11));
                }
            }

            quit[0] = new ImageIcon(alphabet[17].getImage());
            quit[1] = new ImageIcon(alphabet[21].getImage());
            quit[2] = new ImageIcon(alphabet[9].getImage());
            quit[3] = new ImageIcon(alphabet[20].getImage());

        } catch(Exception e){}
        mouseListener = ML.getMouseListener();

        playRect = new Rect(WindowConstants.SCREEN_WIDTH/2 - (play.getIconWidth()*scale)/2,WindowConstants.SCREEN_HEIGHT/2,play.getIconWidth() * scale,play.getIconHeight() * scale);
        quitRect = new Rect(WindowConstants.SCREEN_WIDTH/2 - (quit[0].getIconWidth()*scale*4)/2,WindowConstants.SCREEN_HEIGHT - 100,quit[0].getIconWidth() * scale*4,quit[0].getIconHeight() * scale);
    }


    @Override
    public void update(double deltaTime) {

        hoveringOverPlay = mouseListener.isMouseInsideRect(playRect.x,playRect.y,playRect.w,playRect.h);
        hoveringOverQuit = mouseListener.isMouseInsideRect(quitRect.x,quitRect.y,quitRect.w,quitRect.h);

        if (hoveringOverPlay && mouseListener.isPressed(MouseEvent.BUTTON1)){
            Window.getWindow().changeState(WindowConstants.GAME_SCENE);
        }
        if (hoveringOverQuit && mouseListener.isPressed(MouseEvent.BUTTON1) && Window.windowsChangeCoolDown <= 0.f){
            System.exit(69);
        }

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE)){
            Window.getWindow().changeState(WindowConstants.GAME_SCENE);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_SPACE)){
            Window.getWindow().changeState(WindowConstants.CSS_SCENE);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_F1)){
            Window.getWindow().changeState(WindowConstants.EDITOR_SCENE);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(bg,0,0,null);
        g.drawImage(hero,0,0,null);

        g.setColor(new Color(0, 0, 0, 120));
        g.fillRect(0,0,WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);

        g.drawImage(play.getImage(),WindowConstants.SCREEN_WIDTH/2 - (play.getIconWidth()*scale)/2,WindowConstants.SCREEN_HEIGHT/2,play.getIconWidth() * scale,play.getIconHeight() * scale,null);

        //quit
        for (int i=0;i< quit.length;i++) {
            g.drawImage(quit[i].getImage(),(WindowConstants.SCREEN_WIDTH/2 + ((offset-1)*i*scale) - (quit[i].getIconWidth()*scale)*2), WindowConstants.SCREEN_HEIGHT - 100,(quit[i].getIconWidth()*scale),(quit[i].getIconHeight() * scale), null);
        }

        if(hoveringOverPlay) {
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 - (play.getIconWidth()*scale)), WindowConstants.SCREEN_HEIGHT/2,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 + (play.getIconWidth()*scale)/2 + cursor.getIconWidth()*scale), WindowConstants.SCREEN_HEIGHT/2,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
        }
        if(hoveringOverQuit) {
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 - (play.getIconWidth()*scale)), WindowConstants.SCREEN_HEIGHT-100,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 + (play.getIconWidth()*scale)/2 + cursor.getIconWidth()*scale), WindowConstants.SCREEN_HEIGHT-100,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
        }
    }
}
