package solution.coronagame;

import solution.engine.logic.GameLogic;
import solution.engine.graphics.Renderer;

public class CoronaGame implements GameLogic {

    Player player;

    @Override
    public void render(Renderer renderer) {
       player.render(renderer);
    }

    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);
    }

    @Override
    public void init() {
        player = new Player();
    }

}