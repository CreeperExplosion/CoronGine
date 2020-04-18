package solution.engine.logic;

import solution.engine.graphics.Renderer;


public interface GameImplementation {
    public void init();
    public void render(Renderer renderer);
    public void update(float deltaTime);
}