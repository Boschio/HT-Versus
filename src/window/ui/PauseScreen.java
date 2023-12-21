package window.ui;

import util.Rect;
import util.io.ML;
import window.WindowConstants;
import window.scenes.GameScene;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import static window.Window.getWindow;

public class PauseScreen {

    private GameScene gs;

    private ML mouseListener;
    private int scale = 3;
    boolean hoveringOverCont, hoveringOverQuit;

    private BufferedImage bg;
    private ImageIcon cursor, cont;

    private Rect contRect, quitRect;

    private ImageIcon[] alphabet = new ImageIcon[32];
    private ImageIcon[] quit = new ImageIcon[4];

    int offset = 12;

    public PauseScreen(GameScene gs) {
        try {
            this.gs = gs;

            bg = ImageIO.read(new File("./src/images/Menu/pause-bg.png"));
            BufferedImage ui = ImageIO.read(new File("./src/images/ui.png"));

            cursor = new ImageIcon(ui.getSubimage(344,16,16,16));
            cont = new ImageIcon(ui.getSubimage(386,41,93,14));

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

        contRect = new Rect(WindowConstants.SCREEN_WIDTH/2 - (cont.getIconWidth()*scale)/2,WindowConstants.SCREEN_HEIGHT/2,cont.getIconWidth() * scale,cont.getIconHeight() * scale);
        quitRect = new Rect(WindowConstants.SCREEN_WIDTH/2 - (quit[0].getIconWidth()*scale*4)/2,WindowConstants.SCREEN_HEIGHT - 100,quit[0].getIconWidth() * scale*4,quit[0].getIconHeight() * scale);
    }

    public void update() {
        hoveringOverCont= mouseListener.isMouseInsideRect(contRect.x,contRect.y,contRect.w,contRect.h);
        hoveringOverQuit = mouseListener.isMouseInsideRect(quitRect.x,quitRect.y,quitRect.w,quitRect.h);

        if (hoveringOverCont && mouseListener.isPressed(MouseEvent.BUTTON1)){
            gs.isPaused = false;
        }
        if (hoveringOverQuit && mouseListener.isPressed(MouseEvent.BUTTON1)){
            getWindow().changeState(WindowConstants.MENU_SCENE);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(bg,0,0,null);
        g.drawImage(cont.getImage(),WindowConstants.SCREEN_WIDTH/2 - (cont.getIconWidth()*scale)/2,WindowConstants.SCREEN_HEIGHT/2,cont.getIconWidth() * scale,cont.getIconHeight() * scale,null);

        //quit
        for (int i=0;i< quit.length;i++) {
            g.drawImage(quit[i].getImage(),(WindowConstants.SCREEN_WIDTH/2 + ((offset-1)*i*scale) - (quit[i].getIconWidth()*scale)*2), WindowConstants.SCREEN_HEIGHT - 100,(quit[i].getIconWidth()*scale),(quit[i].getIconHeight() * scale), null);
        }

        if(hoveringOverCont) {
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 - (cont.getIconWidth()*scale)), WindowConstants.SCREEN_HEIGHT/2,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 + (cont.getIconWidth()*scale)/2 + cursor.getIconWidth()*scale), WindowConstants.SCREEN_HEIGHT/2,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
        }
        if(hoveringOverQuit) {
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 - (cont.getIconWidth()*scale)), WindowConstants.SCREEN_HEIGHT-100,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
            g.drawImage(cursor.getImage(),(WindowConstants.SCREEN_WIDTH/2 + (cont.getIconWidth()*scale)/2 + cursor.getIconWidth()*scale), WindowConstants.SCREEN_HEIGHT-100,(cursor.getIconWidth()*scale),(cursor.getIconHeight() * scale), null);
        }
    }


}
