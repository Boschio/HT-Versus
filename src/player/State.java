package player;

import util.io.KL;

public interface State {

    void enter(Fighter fighter);
    State input(KL keyListener);
    State update(Fighter fighter, double deltaTime);

//    State physicsProcess(double deltaTime);
}
