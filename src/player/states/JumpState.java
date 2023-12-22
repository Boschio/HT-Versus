package player.states;

import player.Fighter;
import player.FighterConstants;

public class JumpState extends State {
    public JumpState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {
        fighter.vy -= fighter.jumpHeight;
    }

    public State update(double deltaTime) {
        fighter.currAction = fighter.JUMP;

        fighter.y += fighter.vy * deltaTime;
        fighter.vy += fighter.ay * deltaTime;

        if (fighter.animator.getCurrentFrame().getIconHeight() + fighter.y >= FighterConstants.FLOOR) {
            pushAbove(FighterConstants.FLOOR);
            stopFalling();

            return fighter.idleState;
        }
        return null;
    }

    public void stopFalling() {
        fighter.vx = 0;
        fighter.vy = 0;
    }

    public void pushAbove(double floor) {
        fighter.y = floor - fighter.animator.getCurrentFrame().getIconHeight();
    }

}
