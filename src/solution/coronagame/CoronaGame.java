package solution.coronagame;

import solution.engine.logic.GameImplementation;
import solution.engine.graphics.Renderer;

public class CoronaGame implements GameImplementation {

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