package solution.engine.states;

import solution.engine.logic.GameImplementation;
import solution.engine.graphics.Renderer;

public class GameState extends State {
    GameImplementation gameImplementation;

    public GameState(GameImplementation gameImplementation){
        this.gameImplementation = gameImplementation;
    }

    @Override
    public void init() {
        gameImplementation.init();
    }

    @Override
    public void render(Renderer renderer) {
        gameImplementation.render(renderer);
    }

    @Override
    public void update(float deltaTime) {
        gameImplementation.update(deltaTime);
    }
}
