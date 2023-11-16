package component;

import util.HurtBox;
import util.Rect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Animation {
    private ArrayList<ImageIcon> frames = new ArrayList<>();
    private ArrayList<HurtBox> hurtBoxes = new ArrayList<>();
    public int xOffset = 0;
    public int yOffset = 0;
    public double scaleFactor = 3;

    public Animation(String path, Rect rects[], HurtBox hurtBoxes[]){
        try{
            BufferedImage spriteSheet = ImageIO.read(new File(path));
            for (Rect rect:rects) {
                ImageIcon ImageIcon = new ImageIcon(spriteSheet.getSubimage(
                        (int) rect.x,
                        (int) rect.y,
                        (int) rect.w,
                        (int) rect.h));
                frames.add(ImageIcon);
            }

            for (HurtBox hurtbox: hurtBoxes) {

                this.hurtBoxes.add(hurtbox);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Animation(String path, Rect rects[], int xOffset, int yOffset, double scaleFactor){
        try{
            BufferedImage spriteSheet = ImageIO.read(new File(path));
            for (Rect rect:rects) {
                ImageIcon ImageIcon = new ImageIcon(spriteSheet.getSubimage(
                        (int) rect.x,
                        (int) rect.y,
                        (int) rect.w,
                        (int) rect.h));
                frames.add(ImageIcon);
            }
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            this.scaleFactor = scaleFactor;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ImageIcon getFrame(int index){
        return frames.get(index);
    }

    public HurtBox getHurtBox(int index){
        return hurtBoxes.get(index);
    }

    public int AnimationLength(){
        return frames.size();
    }
}