package solution.Game.logic;

import java.awt.Graphics2D;

public interface GameLogic {
    public void init();
    public void render(Graphics2D graphics);
    public void update();
}