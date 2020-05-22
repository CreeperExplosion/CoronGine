package solution.engine.logic;

import java.util.ArrayList;

import solution.engine.gameobject.GameObject;
import solution.engine.graphics.Camera;
import solution.engine.graphics.Renderer;

public abstract class Scene {

    public Camera camera = new Camera();
    public ArrayList<GameObject> gameObjects = new ArrayList<>();
    public Renderer renderer;
    protected boolean running = false;
    protected boolean initialized = false;
    private SceneManager manager;
    public float brightness;

    public abstract void init();

    public abstract void onSelected();

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

    protected void ascendObject(String name, GameObject object) {
        manager.ascendedObjects.put(name, object);
    }

    protected GameObject descendObject(String name) {
        return manager.ascendedObjects.get(name);
    }

    protected void removeAscendedObject(String name) {
        manager.ascendedObjects.remove(name);
    }

    public void update(final float deltaTime) {
        for (var obj : gameObjects) {
            obj.update(deltaTime, this);
        }

        renderer.setWorldBrightness(brightness);
    }

    public void addGameObjects(GameObject... objs) {
        for (var obj : objs) {
            gameObjects.add(obj);
        }
    }

}
