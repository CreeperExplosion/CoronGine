package solution.Game.logic;

import java.awt.Graphics2D;

import solution.graphics.Renderer;


public interface GameLogic {
    public void init();
    public void render(Renderer renderer);
    public void update(float deltaTime);
}