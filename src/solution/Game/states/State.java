package solution.Game.states;

import java.awt.*;

public abstract class State{

    private static State currentState = null;

    public static void setState(State state) {
        State.currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    public abstract void init();
    public abstract void render(Graphics2D graphics);
    public abstract void update(float deltaTime);
}
