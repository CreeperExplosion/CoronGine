package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;
import solution.engine.graphics.Renderer;

public class ObjectHandler {


    public void init() {
        
    }


    public void update(float deltaTime){

    }

    public void render(Renderer renderer) {
        for (Renderable renderable : Renderable.RENDERABLES) {
            renderable.render(renderer);
        }
    }
}   