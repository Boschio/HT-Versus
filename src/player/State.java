package player;

import java.awt.event.KeyEvent;

public interface State {

    void enter();
    void exit();
    State input(KeyEvent e);
    State update(double deltaTime);

}
