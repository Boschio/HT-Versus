package player.states;

import player.Fighter;
import player.FighterConstants;
import util.io.KL;

public class JumpState extends State {
    public JumpState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.vy -= fighter.jumpHeight;
    }

    public State input(KL e) {
        return null;
    }

    public State update(double deltaTime) {
        fighter.pose = fighter.JUMP;

        fighter.y += fighter.vy * deltaTime;
        fighter.vy += fighter.ay * deltaTime;

        if (fighter.animator.getCurrentFrame().getIconHeight() + fighter.y >= FighterConstants.FLOOR) {
            pushAbove(FighterConstants.FLOOR);
            stopFalling();

            return fighter.idleState;
        }
        return null;
    }

    private void jump(double dy, double dx) {
        // y = a(x-h)2 + k, where h is the vertex or x^2 = -4ay
        fighter.vy -= dy;
    }

    public void stopFalling() {
        fighter.vx = 0;
        fighter.vy = 0;
    }

    public void pushAbove(double floor) {
        fighter.y = floor - fighter.animator.getCurrentFrame().getIconHeight() - 1;
    }

}
