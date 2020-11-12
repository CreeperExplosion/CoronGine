package solution.coronagame.Scenes;

import solution.engine.Components.LightEmmiter;
import solution.engine.Components.Renderable;
import solution.engine.gameobject.GameObject;
import solution.engine.logic.Scene;

public class GameScene extends Scene {

    GameObject player = new GameObject();
    GameObject lampPost = new GameObject();

    @Override
    public void init() {

        this.brightness = 0.5f;
        
        player.addComponents(new Renderable("/test.png"));

        lampPost.addComponents(new LightEmmiter("/TestLight.png", 1f, 4f));

        addGameObjects(player, lampPost);
    }

    @Override
    public void onSelected() {
        // TODO Auto-generated method stub
    }
}