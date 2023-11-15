package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class JumpState implements State {
    @Override
    public void enter(Fighter fighter) {
        fighter.vy -= fighter.jumpHeight;
    }

    @Override
    public State input(KL e) {
        return null;
    }

    @Override
    public State update(Fighter fighter, double deltaTime) {
        fighter.pose = fighter.JUMP;
//        fighter.x += fighter.vx * deltaTime;
        fighter.y += fighter.vy * deltaTime;
        fighter.vy += fighter.ay * deltaTime;

        if (fighter.animator.getCurrentFrame().getIconHeight() + fighter.y >= FighterConstants.FLOOR) {
            pushAbove(fighter, FighterConstants.FLOOR);
            stopFalling(fighter);
            return new IdleState();
        }
        return null;
    }

    private void jump(Fighter fighter, double dy, double dx) {
        // y = a(x-h)2 + k, where h is the vertex or x^2 = -4ay
        fighter.vy -= dy;
//        player.vx = dx;
    }

    public void stopFalling(Fighter fighter) {
        fighter.vx = 0;
        fighter.vy = 0;
    }

    public void pushAbove(Fighter fighter, double floor) {
        fighter.y = floor - fighter.animator.getCurrentFrame().getIconHeight() - 1;
    }

}
