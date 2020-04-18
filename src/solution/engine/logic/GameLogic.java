package solution.engine.logic;

import solution.engine.graphics.Renderer;


public interface GameLogic {
    public void init();
    public void render(Renderer renderer);
    public void update(float deltaTime);
}