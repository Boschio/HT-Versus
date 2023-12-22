package player.states;

import player.Fighter;

public abstract class State {
    Fighter fighter;
    public State(Fighter fighter) {
        this.fighter = fighter;
    }

    public void enter() {

    }

    public State update(double deltaTime) {
        return this;
    }
}
