package player.states;

import player.Fighter;
import util.io.KL;

public abstract class State {
    Fighter fighter;
    public State(Fighter fighter) {
        this.fighter = fighter;
    }

    public void enter() {

    }

    public State input(KL keyListener) {
        return null;
    }

    public State update(double deltaTime) {
        return null;
    }

//    State physicsProcess(double deltaTime);
}
