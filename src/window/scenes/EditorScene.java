package window.scenes;

import player.Fighter;
import player.FighterConstants;
import player.Ryu;
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

    private String _debugInfo = "";
    private String _debugInfo2 = "";
    HurtBox addHurt= new HurtBox(25, 50, 60,60);
    HitBox addHit= new HitBox(95, 50, 60,60);
    LinkedList<HurtBox> hurtBoxes = new LinkedList<>();
    LinkedList<HitBox> hitBoxes = new LinkedList<>();

    ML mouseListener = ML.getMouseListener();
    private int mx = (int) mouseListener.getX();
    private int my = (int) mouseListener.getY();

    Fighter ryu = new Ryu((int) FighterConstants.PLAYER1_START_X, (int) FighterConstants.PLAYER_START_Y-100, 80, 80);
    boolean keyDown = false;
    boolean mouseDown = false;
    int x = 180;
    int y = 30;

    @Override
    public void update(double deltaTime) {
        _debugInfo = String.format("Current Frame: %d", ryu.animator.getCurrentFrameIndex()+1);
        _debugInfo2 = String.format("Total Frames: %d", ryu.animator.getTotalFrames());


        int nx = (int) mouseListener.getX();
        int ny = (int) mouseListener.getY();

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_W)){
            ryu.animator.debugChangeAnimation(ryu.JUMP);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_A)){
            ryu.animator.debugChangeAnimation(ryu.WALKBACKWARD);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_S)){
            ryu.animator.debugChangeAnimation(ryu.IDLE);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_D)){
            ryu.animator.debugChangeAnimation(ryu.WALKFORWARD);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_J)){
            ryu.animator.debugChangeAnimation(ryu.LIGHTATTACK);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_K)){
            ryu.animator.debugChangeAnimation(ryu.MEDIUMATTACK);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_L)){
            ryu.animator.debugChangeAnimation(ryu.HEAVYATTACK);
        }

        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_LEFT) && keyDown == false) {
            keyDown = true;
            ryu.animator.debugSetCurrentFrameIndex(-1);
        }
        if(KL.getKeyListener().isKeyDown(KeyEvent.VK_RIGHT) && keyDown == false) {
            keyDown = true;
            ryu.animator.debugSetCurrentFrameIndex(+1);
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
                System.out.println(hitBox.toString());
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

        ryu.draw(g);

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

        g.setColor(Color.BLACK);
        Font myFont = new Font ("Courier New", 1, 17);
        g.setFont(myFont);
        g.drawString(_debugInfo,WindowConstants.SCREEN_WIDTH-300, (int) (WindowConstants.INSET_SIZE*1.5));
        g.drawString(_debugInfo2,WindowConstants.SCREEN_WIDTH-300, (int) (WindowConstants.INSET_SIZE*1.5)+18);

    }

}