package window.scenes;

import player.FighterConstants;
import player.Player;
import util.HitBox;
import util.HurtBox;
import util.io.KL;
import util.io.ML;
import window.Window;
import window.WindowConstants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class EditorScene extends Scene {
    HurtBox addHurt= new HurtBox(25, 50, 60,60);
    HitBox addHit= new HitBox(95, 50, 60,60);
    LinkedList<HurtBox> hurtBoxes = new LinkedList<>();
    LinkedList<HitBox> hitBoxes = new LinkedList<>();

    ML mouseListener = ML.getMouseListener();
    private int mx = (int) mouseListener.getX();
    private int my = (int) mouseListener.getY();

    Player player1 = new Player(1, FighterConstants.Characters.Ryu);
    boolean keyDown = false;
    boolean mouseDown = false;
    int x = 180;
    int y = 30;

    @Override
    public void update(double deltaTime) {
        int nx = (int) mouseListener.getX();
        int ny = (int) mouseListener.getY();

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_Q)){
            player1.animator.debugChangeAnimation(player1.IDLE);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_W)){
            player1.animator.debugChangeAnimation(player1.JUMP);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_A)){
            player1.animator.debugChangeAnimation(player1.WALKBACKWARD);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_S)){
            player1.animator.debugChangeAnimation(player1.CROUCHING);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_D)){
            player1.animator.debugChangeAnimation(player1.WALKFORWARD);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_J)){
            player1.animator.debugChangeAnimation(player1.L_ATTACK);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_K)){
            player1.animator.debugChangeAnimation(player1.M_ATTACK);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_COMMA)){
            player1.animator.debugChangeAnimation(player1.CROUCH_M_ATTACK);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_L)){
            player1.animator.debugChangeAnimation(player1.H_ATTACK);
        }

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_LEFT) && keyDown == false) {
            keyDown = true;
            player1.animator.debugSetCurrentFrameIndex(-1);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_RIGHT) && keyDown == false) {
            keyDown = true;
            player1.animator.debugSetCurrentFrameIndex(+1);
        }


        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_ESCAPE)){
            Window.getWindow().changeState(WindowConstants.MENU_SCENE);
        }

        if (mouseListener.isMouseInsideRect(addHurt) && mouseListener.isPressed(MouseEvent.BUTTON1) && mouseDown == false){
            mouseDown = true;

            hurtBoxes.push(new HurtBox(x+=20, y+=20,60 ,60));
        }

        for (HurtBox hBox: hurtBoxes) {

            if (mouseListener.isMouseDragging() && mouseListener.isMouseInsideRect(hBox)) {
               hBox.moveBy((nx - mx), (ny - my));
            }
            if (mouseListener.isMouseDragging() && mouseListener.isMouseInsideRect(hBox.resizer)) {
                hBox.resizeBy((nx - mx), (ny - my));
            }

        }

        if (mouseListener.isMouseInsideRect(addHit) && mouseListener.isPressed(MouseEvent.BUTTON1) && mouseDown == false){
            mouseDown = true;

            hitBoxes.push(new HitBox(x+=20, y+=20,60 ,60));
        }

        for (HitBox hitBox: hitBoxes) {

            if (mouseListener.isMouseDragging() && mouseListener.isMouseInsideRect(hitBox)) {
                hitBox.moveBy((nx - mx), (ny - my));
            }
            if (mouseListener.isMouseDragging() && mouseListener.isMouseInsideRect(hitBox.resizer)) {
                hitBox.resizeBy((nx - mx), (ny - my));
            }

        }

        if (KL.getKeyListener().isKeyDown(KeyEvent.VK_P) && keyDown == false) {
            keyDown = true;
            for (HurtBox hurtBox: hurtBoxes) {
                System.out.println(hurtBox.toString());
            }
            for (HitBox hitBox: hitBoxes) {
                System.out.println(hitBox.debugString());
            }
        }

        if (!KL.getKeyListener().isKeyDown(KeyEvent.VK_P) && !KL.getKeyListener().isKeyDown(KeyEvent.VK_LEFT) && !KL.getKeyListener().isKeyDown(KeyEvent.VK_RIGHT)) {
            keyDown = false;
        }
        if (!ML.getMouseListener().isPressed(MouseEvent.BUTTON1)) {
            mouseDown = false;
        }

        mx = nx;
        my = ny;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT);

        player1.draw(g);

        g.setColor(Color.GREEN);
        g.fillRect((int)addHurt.x, (int)addHurt.y, (int)addHurt.w, (int)addHurt.h);

        for (HurtBox hBox : hurtBoxes) {
            hBox.draw(g);
        }

        g.setColor(Color.RED);
        g.fillRect((int)addHit.x, (int)addHit.y, (int)addHit.w, (int)addHit.h);

        for (HitBox hBox : hitBoxes) {
            hBox.draw(g);
        }

        debugInfo(g);
    }

    public void debugInfo(Graphics g) {

        g.setColor(Color.BLACK);
        Font myFont = new Font ("Courier New", 1, 17);
        g.setFont(myFont);

        g.drawString(String.format("Current Frame: %d", player1.animator.getCurrentFrameIndex()+1),WindowConstants.SCREEN_WIDTH-300, (int) (WindowConstants.INSET_SIZE*1.5));
        g.drawString(String.format("Total Frames: %d", player1.animator.getTotalFrames()),WindowConstants.SCREEN_WIDTH-300, (int) (WindowConstants.INSET_SIZE*1.5)+18);

        int hurtBoxInsetGap = 0;
        for (HurtBox hurtBox: hurtBoxes) {
            int insetOffset = 18;

            g.drawString(hurtBox.toString(),WindowConstants.SCREEN_WIDTH-1000, (int) (WindowConstants.INSET_SIZE*1.5)+hurtBoxInsetGap);
            hurtBoxInsetGap += insetOffset;
        }
        int hitBoxInsetGap = 0;
        for (HitBox hitBox: hitBoxes) {
            int insetOffset = 18;

            g.drawString("|  " + hitBox.debugString(),WindowConstants.SCREEN_WIDTH-700, (int) (WindowConstants.INSET_SIZE*1.5)+hitBoxInsetGap);
            hitBoxInsetGap += insetOffset;
        }
    }

}