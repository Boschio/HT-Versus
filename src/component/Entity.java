package component;

import java.awt.Color;
import java.awt.Graphics;

public class Entity {

    public double x;
    public double y;
    public double w;
    public double h;

    public double originX;

    public double vx = 0;
    public double vy = 0;

    public double ay = G; // acceleration

    static final double G = 0.4; // Gravity

    private double maxHealth;
    public double currHealth;

    private boolean toBeDestroyed = false;

    Color c = Color.BLACK;

    public static double scale = 3;

    public Entity(int x, int y, int w, int h, double maxHealth) {
        this.x = x;
        this.y = y;

        // Need to make sure h and w are not negative
        this.w = w;
        this.h = h;

        this.originX = this.x + (this.w/2);

        this.maxHealth = maxHealth;
        this.currHealth = maxHealth;
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

//    public Entity(int x, int y, int w, int h, Color c) {
//        this(x, y, w, h);
//        setColor(c);
//    }

    public void takeDamage(double d){
        currHealth -= d;

        if(currHealth <= 0){
            this.destroy();
        }
    }

    public void destroy() {
        toBeDestroyed = true;
    }

    public boolean isToBeDestroyed(){
        return toBeDestroyed;
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public void draw(Graphics g) {
//        this.drawDebug(g);
    }

//    public void drawDebug(Graphics g) {
//        g.setColor(Color.green);
//        g.drawLine((int) (x-8), (int) y, (int) (x+7), (int) y);
//        g.drawLine((int) (x), (int) (y-8), (int) (x), (int) (y+7));
//    }

}
