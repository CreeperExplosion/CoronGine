package solution.Game.states;

import solution.Game.assets.Assets;
import solution.Game.gameobject.Player;
import solution.Game.logic.GameLogic;

import java.awt.*;

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
    public void render(Graphics2D graphics) {
        gameLogic.render(graphics);
    }

    @Override
    public void update(float deltaTime) {
        gameLogic.update(deltaTime);
    }
}
