package solution.Game;

import solution.Game.logic.GameLogic;
import solution.graphics.Renderer;
import solution.Game.gameobject.Player;

import java.awt.Graphics2D;
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