package component;

import util.Rect;

import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Animate {
    private Map<String, AnimateTest> Animations = new HashMap<>();
    private AnimateTest currentAnimation = null;
    private ImageIcon currentFrame = null;
    private int currentFrameIndex = 0;
    private double defaultFrameTime = 0.15;
    private double frameTime = 0.15;
    private double lastFrame = 0;


    public Animate(){
    }
    public Animate(double defaultFrameTime){
        this.defaultFrameTime    = defaultFrameTime;
        this.frameTime           = defaultFrameTime;
    }

    public void createAnimation(String AnimationName, String path, Rect[] rects){

        Animations.put(AnimationName, new AnimateTest(path, rects));
        if (currentAnimation == null){
            currentAnimation = Animations.get(AnimationName);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);
        }
    }

    public void createAnimation(String AnimationName, String path, Rect[] rects, int xOffset, int yOffset){

        Animations.put(AnimationName, new AnimateTest(path, rects));
        if (currentAnimation == null){
            currentAnimation = Animations.get(AnimationName);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);
        }
        Animations.get(AnimationName).xOffset = xOffset;
        Animations.get(AnimationName).yOffset = yOffset;
    }

    public void createAnimation(String animation_ID, String path, Rect[] rects, int xOffset, int yOffset, double scaleFactor){

        Animations.put(animation_ID, new AnimateTest(path, rects, xOffset, yOffset, scaleFactor));
        if (currentAnimation == null){
            currentAnimation = Animations.get(animation_ID);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);
        }
    }

    public void addAnimation(AnimateTest animation, String animation_ID){
        Animations.put(animation_ID,animation);
        if (currentAnimation == null){
            currentAnimation = Animations.get(animation_ID);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);
        }
    }

    public void changeAnimationTo(String AnimationName){
        if(Animations.containsKey(AnimationName)){
            currentAnimation = Animations.get(AnimationName);
            currentFrameIndex = 0;
        }
    }

    public void changeAnimationNotReset(String AnimationName){
        this.frameTime = defaultFrameTime;
        if(Animations.containsKey(AnimationName)){
            currentAnimation = Animations.get(AnimationName);
        }
    }

    public void changeAnimationTo(String AnimationName, double frameTime){

        this.setFrameTime(frameTime);
        if(Animations.containsKey(AnimationName)){
            currentAnimation = Animations.get(AnimationName);
            currentFrameIndex = 0;
        }

    }

    public void changeAnimationNotReset(String AnimationName, double frameTime){
        if(Animations.containsKey(AnimationName)){
            currentAnimation = Animations.get(AnimationName);
        }
        this.setFrameTime(frameTime);
    }

    public double getFrameTime() {
        return frameTime;
    }

    public void setFrameTime(double frameTime) {
        this.frameTime = frameTime;
    }

    public ImageIcon getCurrentFrame() {
        return currentFrame;
    }

    public boolean hasAnimations(){
        return (!Animations.isEmpty());
    }

    public void setCurrentAnimationOffset(int xOffset, int yOffset){
        currentAnimation.xOffset = xOffset;
        currentAnimation.yOffset = yOffset;
    }

    public void RenderCurrentSprite(Graphics g,int x, int y){
        int w = (int) (currentFrame.getIconWidth() * currentAnimation.scaleFactor);
        int h = (int) (currentFrame.getIconHeight() * currentAnimation.scaleFactor);
        g.drawImage(
                currentFrame.getImage(),
                (int) (x + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2),
                (int) (y + currentAnimation.yOffset * currentAnimation.scaleFactor - h),
                (int) (currentFrame.getIconWidth() * currentAnimation.scaleFactor),
                (int) (currentFrame.getIconHeight() * currentAnimation.scaleFactor),
                null
        );
        g.setColor(Color.red);
        g.drawRect((int)(x + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2), (int)(y + currentAnimation.yOffset * currentAnimation.scaleFactor - h), w, h);

        g.setColor(Color.green);
        g.drawLine((int) (x-8), (int) y, (int) (x+7), (int) y);
        g.drawLine((int) (x), (int) (y-8), (int) (x), (int) (y+7));
    }

    public void RenderCurrentSpriteFlipVer(Graphics g,int x, int y){
        g.drawImage(
                currentFrame.getImage(),
                (int) (x + currentAnimation.xOffset + currentFrame.getIconWidth() * currentAnimation.scaleFactor),
                (int) (y + currentAnimation.yOffset),
                (int) (-currentFrame.getIconWidth() * currentAnimation.scaleFactor),
                (int) (currentFrame.getIconHeight() * currentAnimation.scaleFactor),
                null
        );
    }


    public void RenderCurrentSpriteFlipHor(Graphics g,int x, int y){
        g.drawImage(
                currentFrame.getImage(),
                (int) (x + currentAnimation.xOffset),
                (int) (y + currentAnimation.yOffset + currentFrame.getIconHeight() * currentAnimation.scaleFactor),
                (int) (currentFrame.getIconWidth() * currentAnimation.scaleFactor),
                (int) (-currentFrame.getIconHeight() * currentAnimation.scaleFactor),
                null
        );
    }

    public void RenderCurrentSpriteFlipBoth(Graphics g,int x, int y){
        g.drawImage(
                currentFrame.getImage(),
                (int) (x + currentAnimation.xOffset + currentFrame.getIconWidth() * currentAnimation.scaleFactor),
                (int) (y + currentAnimation.yOffset + currentFrame.getIconHeight() * currentAnimation.scaleFactor),
                (int) (-currentFrame.getIconWidth() * currentAnimation.scaleFactor),
                (int) (-currentFrame.getIconHeight() * currentAnimation.scaleFactor),
                null
        );
    }


    public void init() {

    }


    public void update(double deltaTime) {
        lastFrame += deltaTime;

        if (currentAnimation!=null){
            if(lastFrame>frameTime){
                boolean arrayOverFlow = currentFrameIndex + 1 > currentAnimation.AnimationLength() - 1 ;

                currentFrameIndex = arrayOverFlow ? 0 : currentFrameIndex + 1;
                currentFrame = currentAnimation.getFrame(currentFrameIndex);
                lastFrame = 0;
            }
        }
    }

    public void draw(Graphics g) {

    }
}


