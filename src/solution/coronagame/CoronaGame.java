package solution.coronagame;

import solution.engine.logic.SceneManager;
import solution.coronagame.Scenes.GameScene;
import solution.engine.Util.Timer;

public class CoronaGame extends SceneManager {

    Timer timer;

    GameScene game = new GameScene();

    @Override
    public void init() {
        // setScene(game);
    }

    @Override
    protected void switchScene(String sceneName) {
    }

}