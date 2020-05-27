package solution.coronagame.Scenes;

import solution.engine.Components.Renderable;
import solution.engine.gameobject.GameObject;
import solution.engine.logic.Scene;

public class GameScene extends Scene {

    GameObject player = new GameObject();

    @Override
    public void init() {
        player.addComponents(new Renderable("/test.png"));
        addGameObjects(player);
    }

    @Override
    public void onSelected() {

    }

}