package player.states;

import player.Fighter;
import util.io.KL;

public class JumpForwardState extends State {
    public JumpForwardState(Fighter fighter) {
        super(fighter);
    }

    public void enter() {

    }

    public State input(KL e) {
        return null;
    }

    public State update(double deltaTime) {
        return null;
    }
}
