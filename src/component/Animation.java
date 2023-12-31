package component;

import util.HitBox;
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
    private ArrayList<HitBox> hitBoxes = new ArrayList<>();
    public int[] frameHold;


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

    public Animation(String path, Rect rects[], HurtBox hurtBoxes[], int[] frameHold){
        this(path, rects,hurtBoxes);

        try {
            this.frameHold = frameHold;
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Animation(String path, Rect rects[], HurtBox hurtBoxes[], HitBox hitBoxes[]){
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

            for (HitBox hitbox: hitBoxes) {

                this.hitBoxes.add(hitbox);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Animation(String path, Rect rects[], HurtBox hurtBoxes[], HitBox hitBoxes[], int[] frameHold){
        this(path, rects,hurtBoxes,hitBoxes);
        try{
            this.frameHold = frameHold;
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
    public HitBox getHitBox(int index) {
        return hitBoxes.get(index);
    }

    public int getHitBoxesLength() {
        return hitBoxes.size();
    }

    public int getAnimationLength(){
        return frames.size();
    }
    public int getFrameHoldLength(){
        int total = 0;
        for (int frame: frameHold) {
            total += frame;
        }
        return total;
    }


}