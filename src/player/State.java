package player;

import util.io.KL;

public interface State {

    void enter(Player player);
    void exit();
    State input(KL keyListener);
    State update(Player player, double deltaTime);

//    State physicsProcess(double deltaTime);
}
