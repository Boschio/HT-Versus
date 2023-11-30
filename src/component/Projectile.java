package component;

import java.awt.*;

public class Projectile extends Entity {

    Entity owner;
    public final Animator animator;

    public Projectile(Entity owner, int x, int y, int w, int h) {
        super(x, y, (int)(w*scale), (int)(h*scale), 5);
        this.owner = owner;
        this.animator = new Animator(0.150);
    }

    public void update(double deltaTime) {
        animator.update(deltaTime);
    }

    public void draw(Graphics g) {
        super.draw(g);

        if(animator.hasAnimations()) {
            animator.RenderCurrentSprite(g, (int) x, (int) y);
            // Refactor to HitBox
            animator.RenderCurrentHurtBox(g, (int) x, (int) y);
        }
    }

}
