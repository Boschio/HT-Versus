package window;

import util.Time;
import util.io.KL;
import util.io.ML;
import window.scenes.*;


import javax.swing.*;
import java.awt.*;



//TODO: implement chapter 2 of the textbook to add v-sync/full-screen in this window

public class Window extends JFrame implements Runnable {

    private static Window window = null;

    private boolean isRunning;

    private Scene currentScene;

    public static double windowsChangeCoolDown = 0.f;



    private Window(int width, int height, String title){
        setSize(width,height);
        setTitle(title);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isRunning = true;
        changeState(WindowConstants.MENU_SCENE);
        WindowConstants.INSET_SIZE = getInsets().top;
        addKeyListener(KL.getKeyListener());
        addMouseListener(ML.getMouseListener());
        addMouseMotionListener(ML.getMouseListener());

    }

    /**
     * <p>
     * Creates singleton Instance of the window.Window class to be used across the entire program.
     *</p>
     * @return      The Singleton instance
     */
    public static Window getWindow(){
        if(Window.window == null){
            Window.window = new Window(WindowConstants.SCREEN_WIDTH, WindowConstants.SCREEN_HEIGHT, WindowConstants.SCREEN_TITLE);
        }
        return Window.window;
    }





    /**
     * <p>
     * Changes the current scene
     *</p>
     * @param       newState     Pass in an integer to change the current scene(Use Constant Define Values)
     */
    public void changeState(int newState){
        if(windowsChangeCoolDown <=0.f){
            windowsChangeCoolDown = 1.0;
            switch (newState){
                case 0:
                    currentScene = new MenuScene();
                    break;
                case 1:
                    currentScene = new GameScene();
                    break;
                case 2:
                    currentScene = new EditorScene();
                    break;
                case 3:
                    currentScene = new CharacterSelectScene();
                    break;
                default:
                    System.out.println("Unknown window.scenes.Scene");
                    currentScene = null;
                    break;

            }
        }

    }

    /**<p>
     * Calls the update method for the current scene and sets up and calls the draw method right after
     * <br>
     * <br>
     * This calls always occurs first. Process the logic in this methods.
     * </p>
     * */
    private void update(double deltaTime) {

        currentScene.update(deltaTime);



        Image dbImage = createImage(getWidth(),getHeight());
        Graphics dbg = dbImage.getGraphics();

        this.draw(dbg);

        getGraphics().drawImage(dbImage,0,0,this );

        windowsChangeCoolDown = windowsChangeCoolDown - deltaTime;


    }

    /**<p>
     * Calls the draw method for the current scene.
     * <br>
     * <br>
     * This calls always occur after the update methods
     * </p>
     * */
    private void draw(Graphics g){

        currentScene.draw(g);

    }

    /**<p>
     * Entry point of the window.Window class(besides the constructor) starts executing when the thread is started
     * <br>
     * <br>
     * uses the util.Time class to calculate the time since last frame.
     * </p>
     * */
    @Override
    public void run() {
        this.requestFocus();
        double lastFrameTime = 0.0;
        try{
//          main game loop happens here & delta time gets calculated at the start of the frame
            while(isRunning){
                double time =  Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                Time.update(deltaTime);
//                System.out.println("Frame: " + Time.frame);

                update(deltaTime);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        this.dispose();
    }
}
