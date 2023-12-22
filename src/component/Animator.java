package component;

import util.HitBox;
import util.HurtBox;
import util.Rect;
import util.Time;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Animator {
    private Map<String, Animation> Animations = new HashMap<>();
    private String animationName;
    private Animation currentAnimation = null;
    private ImageIcon currentFrame = null;
    private HurtBox currentHurtBox = null;
    private HitBox currentHitBox = null;
    private int currentFrameIndex = 0;
    private double defaultFrameTime = 0.15;
    private double frameTime = 0.15;
    private double lastFrame = 0;

    public int framesLength = Animations.size();

    public Animator(){
    }
    public Animator(double defaultFrameTime){
        this.defaultFrameTime    = defaultFrameTime;
        this.frameTime           = defaultFrameTime;
    }

    public String getAnimationName() {
        return animationName;
    }

    public void createAnimation(String AnimationName, String path, Rect[] rects, HurtBox hurtBoxes[]){
        this.animationName = AnimationName;
        Animations.put(AnimationName, new Animation(path, rects, hurtBoxes));
        if (currentAnimation == null){
            currentAnimation = Animations.get(AnimationName);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);

            currentHurtBox = currentAnimation.getHurtBox(currentFrameIndex);
        }
    }

    public void createAnimation(String AnimationName, String path, Rect[] rects, HurtBox hurtBoxes[], HitBox hitBoxes[]){

        Animations.put(AnimationName, new Animation(path, rects, hurtBoxes, hitBoxes));
        if (currentAnimation == null){
            currentAnimation = Animations.get(AnimationName);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);

            currentHurtBox = currentAnimation.getHurtBox(currentFrameIndex);
            currentHitBox = currentAnimation.getHitBox(currentFrameIndex);
        }
    }

    public void createAnimation(String AnimationName, String path, Rect[] rects, HurtBox hurtBoxes[], int xOffset, int yOffset){

        Animations.put(AnimationName, new Animation(path, rects, hurtBoxes));
        if (currentAnimation == null){
            currentAnimation = Animations.get(AnimationName);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);

            currentHurtBox = currentAnimation.getHurtBox(currentFrameIndex);
        }
        Animations.get(AnimationName).xOffset = xOffset;
        Animations.get(AnimationName).yOffset = yOffset;
    }

    public void createAnimation(String animation_ID, String path, Rect[] rects, int xOffset, int yOffset, double scaleFactor){

        Animations.put(animation_ID, new Animation(path, rects, xOffset, yOffset, scaleFactor));
        if (currentAnimation == null){
            currentAnimation = Animations.get(animation_ID);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);

            currentHurtBox = currentAnimation.getHurtBox(currentFrameIndex);
        }
    }

    public void addAnimation(Animation animation, String animation_ID){
        Animations.put(animation_ID,animation);
        if (currentAnimation == null){
            currentAnimation = Animations.get(animation_ID);
            currentFrame = currentAnimation.getFrame(currentFrameIndex);

            if (currentHurtBox != null) {
                currentHurtBox = currentAnimation.getHurtBox(currentFrameIndex);
            }
            if (currentHitBox != null) {
                currentHitBox = currentAnimation.getHitBox(currentFrameIndex);
            }
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

    public Animation getCurrentAnimation() {
        return this.currentAnimation;
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
    public HurtBox getCurrentHurtBox(){
        return (currentHurtBox);
    }
    public HitBox getCurrentHitBox(){
        return (currentHitBox);
    }

    public boolean hasAnimations(){
        return (!Animations.isEmpty());
    }

    public void setCurrentAnimationOffset(int xOffset, int yOffset){
        currentAnimation.xOffset = xOffset;
        currentAnimation.yOffset = yOffset;
    }

    public void RenderCurrentSprite(Graphics g,int originX, int originY){
        int w = (int) (currentFrame.getIconWidth() * currentAnimation.scaleFactor);
        int h = (int) (currentFrame.getIconHeight() * currentAnimation.scaleFactor);

        int x = (int) (originX + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2);
        int y = (int) (originY + currentAnimation.yOffset * currentAnimation.scaleFactor - h);

        g.drawImage(currentFrame.getImage(),x,y,w,h,null);
        g.setColor(Color.BLUE);
        g.drawRect(x, y, w, h);

        g.setColor(Color.green);
        g.drawLine((int) (originX-8), (int) originY, (int) (originX+7), (int) originY);
        g.drawLine((int) (originX), (int) (originY-8), (int) (originX), (int) (originY+7));
    }

    public void RenderCurrentHurtBox(Graphics g, int originX, int originY) {
        int w = (int) (currentHurtBox.w * currentAnimation.scaleFactor);
        int h = (int) (currentHurtBox.h * currentAnimation.scaleFactor);

        int x = (int) (currentHurtBox.x + originX + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2);
        int y = (int) (currentHurtBox.y + originY + currentAnimation.yOffset * currentAnimation.scaleFactor - h);

        g.setColor(Color.GREEN);
        g.drawRect(x, y, w, h);
    }

    public void RenderCurrentHitBox(Graphics g, int originX, int originY) {
        int w = (int) (currentHitBox.w * currentAnimation.scaleFactor);
        int h = (int) (currentHitBox.h * currentAnimation.scaleFactor);

        int x = (int) (originX + currentHitBox.x + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2);
        int y = (int) (originY + currentHitBox.y + currentAnimation.yOffset * currentAnimation.scaleFactor - h);

        g.setColor(Color.RED);
        g.drawRect(x, y, w, h);
    }

    public void RenderCurrentSpriteFlipVer(Graphics g,int originX, int originY){
        int w = (int) (-currentFrame.getIconWidth() * currentAnimation.scaleFactor);
        int h = (int) (currentFrame.getIconHeight() * currentAnimation.scaleFactor);

        int x = (int) (originX + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2);
        int y = (int) (originY + currentAnimation.yOffset * currentAnimation.scaleFactor - h);

        g.drawImage(currentFrame.getImage(),x,y,w,h,null);
        g.setColor(Color.BLUE);
        g.drawRect(x, y, w, h);

        g.setColor(Color.green);
        g.drawLine((int) (originX-8), (int) originY, (int) (originX+7), (int) originY);
        g.drawLine((int) (originX), (int) (originY-8), (int) (originX), (int) (originY+7));
    }

    public void RenderCurrentHurtBoxFlip(Graphics g, int originX, int originY) {
        int w = (int) (currentHurtBox.w * currentAnimation.scaleFactor);
        int h = (int) (currentHurtBox.h * currentAnimation.scaleFactor);

        int x = (int) (originX - currentHurtBox.x + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2);
        int y = (int) (originY + currentHurtBox.y + currentAnimation.yOffset * currentAnimation.scaleFactor - h);

        g.setColor(Color.GREEN);
        g.drawRect(x, y, w, h);
    }

    public void RenderCurrentHitBoxFlip(Graphics g, int originX, int originY) {
        int w = (int) (currentHitBox.w * currentAnimation.scaleFactor);
        int h = (int) (currentHitBox.h * currentAnimation.scaleFactor);

        int x = (int) (originX - currentHitBox.x + currentAnimation.xOffset * currentAnimation.scaleFactor - w/2);
        int y = (int) (originY + currentHitBox.y + currentAnimation.yOffset * currentAnimation.scaleFactor - h);

        g.setColor(Color.RED);
        g.drawRect(x, y, w, h);
    }

    public void update(double deltaTime) {
        if (currentAnimation!=null){
            if(lastFrame < Time.frame){
                lastFrame = currentAnimation.frameHold == null ? Time.frame + 3 : Time.frame + currentAnimation.frameHold[currentFrameIndex];
                boolean arrayOverFlow = currentFrameIndex + 1 > currentAnimation.getAnimationLength() - 1 ;

                currentFrameIndex = arrayOverFlow ? 0 : currentFrameIndex + 1;
                currentFrame = currentAnimation.getFrame(currentFrameIndex);

                currentHurtBox = currentAnimation.getHurtBox(currentFrameIndex);
                if (currentFrameIndex < currentAnimation.getHitBoxesLength()) {
                    currentHitBox = currentAnimation.getHitBox(currentFrameIndex);
                } else {
                    currentHitBox = null;
                }
            }
        }
    }

    public int getCurrentFrameIndex() {
        return this.currentFrameIndex;
    }
    public int getTotalFrames() {
        return this.currentAnimation.getAnimationLength();
    }
    public void debugSetCurrentFrameIndex(int increment) {
        if (increment == 1) {
            boolean arrayOverFlow = currentFrameIndex + 1 > currentAnimation.getAnimationLength() - 1 ;
            currentFrameIndex = arrayOverFlow ? 0 : currentFrameIndex + 1;
            lastFrame = 0;
        } else {
            boolean arrayUnderFlow = currentFrameIndex - 1 < 0;
            currentFrameIndex = arrayUnderFlow ? currentAnimation.getAnimationLength() - 1 : currentFrameIndex - 1;
            lastFrame = currentAnimation.getAnimationLength() - 1;
        }


        currentFrame = currentAnimation.getFrame(currentFrameIndex);
    }

    public void debugChangeAnimation(String animationName) {
        this.changeAnimationTo(animationName);
        currentFrame = currentAnimation.getFrame(currentFrameIndex);
    }

    public void draw(Graphics g) {

    }

}


