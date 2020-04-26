package solution.coronagame;


import solution.coronagame.Scenes.GameScene;
import solution.engine.Util.Timer;
import solution.engine.logic.GameImplementation;
import solution.engine.logic.Scene;


public class CoronaGame extends GameImplementation {

    Player player;

    Enemy enemy;

    Timer timer;

    Scene gameScene;

    @Override
    public void update(float deltaTime) {
        gameScene.update(deltaTime);
    }

    @Override
    public void init() {
        player = new Player();
        player.startRender();

        gameScene = new GameScene(player);
        
        currentScene = gameScene;
    }

}