package solution.coronagame.Scenes;

import solution.engine.Components.Controller;
import solution.engine.Components.LightEmmiter;
import solution.engine.Components.Renderable;
import solution.engine.Components.Sprite;
import solution.engine.Math.Vector2f;
import solution.engine.gameobject.GameObject;
import solution.engine.logic.Scene;

public class GameScene extends Scene {

    GameObject player = new GameObject();
    GameObject lampPost = new GameObject();
    GameObject bg = new GameObject();
    @Override
    public void init() {
        this.brightness = 0.1f;
        
        player.addComponents(new LightEmmiter("/TestLight.png", 1f),
         new Controller(),
         new Sprite("/test.png")
         );


         player.position.x = 16;
         player.position.y =  -16;

        player.getComponent(Sprite.class).index++;
        player.getComponent(LightEmmiter.class).scale = 5f;
        // player.getComponent(LightEmmiter.class).
        player.z = 1;

        player.position = new Vector2f(0f,0f);

       // lampPost.addComponents(new LightEmmiter("/TestLight.png", 1f));
        lampPost.scale = 3f;

        bg.addComponents(new Renderable());
        
        addGameObjects(player, bg);
    }

    @Override
    public void onSelected() {
    }
}