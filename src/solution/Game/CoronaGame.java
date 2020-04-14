package solution.Game;

import solution.Game.logic.GameLogic;
import solution.Game.gameobject.Player;

import java.awt.Graphics2D;
public class CoronaGame implements GameLogic {

    Player player;

    @Override
    public void render(Graphics2D graphics) {
        player.render(graphics);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void init() {
        player = new Player();
    }

}