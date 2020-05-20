package solution.engine.logic;

import java.util.ArrayList;

import solution.engine.gameobject.GameObject;
import solution.engine.graphics.Camera;

public abstract class Scene {

    public Camera camera = new Camera();

    protected ArrayList<GameObject> gameObjects = new ArrayList<>();

    protected boolean running = false;

    protected boolean initialized = false;

    private SceneManager manager;

    void start(SceneManager manager) {
        this.manager = manager;

        if (initialized) {
            onSelected();
            return;
        }

        init();
        initialized = true;
        onSelected();
    }

    protected void changeScene(String changeTo) {
        manager.switchScene(changeTo);
    }

    protected void ascendObject(String name, GameObject object){
        manager.ascendedObjects.put(name, object);
    }

    protected GameObject descendObject(String name) {
        return manager.ascendedObjects.get(name);
    }

    protected void removeAscendedObject(String name) {
        manager.ascendedObjects.remove(name);
    }

    public abstract void init();

    public abstract void update(float deltaTime);

    public abstract void onSelected();

    public void addGameObject(GameObject obj) {
        gameObjects.add(obj);
    }

}
