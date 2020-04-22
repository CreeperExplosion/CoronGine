package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;
import solution.engine.gameobject.properties.Updateable;
import solution.engine.graphics.Renderer;

public class ObjectHandler {


    public void init() {
        
    }


    public void update(float deltaTime){

        for (Updateable updateable : Updateable.UPDATEABLES) {
            updateable.update(deltaTime);
        }
    }

    public void render(Renderer renderer) {
        for (Renderable renderable : Renderable.RENDERABLES) {
            renderable.render(renderer);
        }
    }
}   