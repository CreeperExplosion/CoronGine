package solution.engine.logic;

import solution.engine.graphics.Camera;
import solution.engine.graphics.Renderer;


public interface GameImplementation {

    Camera camera  = new Camera(1, 0, 0);

    public void init();
    public void render(Renderer renderer);
    public void update(float deltaTime);
    
    public default Camera getCamera(){return camera;};
}