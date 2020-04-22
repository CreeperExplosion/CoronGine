package solution.engine.logic;

import solution.engine.graphics.Camera;


public abstract class GameImplementation {

    protected Camera camera  = new Camera(1, 0, 0); 
    
    protected Scene currentScene;

    public abstract void init();
    public abstract void update(float deltaTime);
    
    public Camera getCamera(){return camera;};

    protected void setScene(Scene scene){
        currentScene = scene;
    }
}