package solution.engine.logic;

import java.util.ArrayList;

import solution.engine.gameobject.GameObject;
import solution.engine.graphics.Camera;

public abstract class Scene {

    public Camera camera = new Camera();

    protected ArrayList<GameObject> gameObjects = new ArrayList<>();

    boolean running = false;
    
    public void init() {
        
    }
    
    public void start(){

    }

    public void addGameObject(GameObject obj){
        gameObjects.add(obj);

        if(!running)
            return;
    }
    
}
