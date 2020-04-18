package solution.engine.states;

import solution.engine.logic.GameLogic;
import solution.engine.graphics.Renderer;

public class GameState extends State {
    GameLogic gameLogic;

    public GameState(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    @Override
    public void init() {
        gameLogic.init();
    }

    @Override
    public void render(Renderer renderer) {
        gameLogic.render(renderer);
    }

    @Override
    public void update(float deltaTime) {
        gameLogic.update(deltaTime);
    }
}
