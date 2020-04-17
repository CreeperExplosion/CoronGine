package solution.Game.states;

import java.awt.*;

import solution.graphics.Renderer;

public abstract class State{

    private static State currentState = null;

    public static void setState(State state) {
        State.currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    public abstract void init();
    public abstract void render(Renderer renderer);
    public abstract void update(float deltaTime);
}
