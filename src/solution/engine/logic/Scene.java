package solution.engine.logic;

import solution.engine.graphics.Camera;

public interface Scene {
    
    Camera camera  = new Camera(1, 0, 0); 

    public abstract void update(float deltaTime);
    
    public default Camera getCamera(){
        return camera;
    }
}
