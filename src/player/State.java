package player;

public abstract class State {
    Player player;

    abstract void enter();
    abstract void update();

}
