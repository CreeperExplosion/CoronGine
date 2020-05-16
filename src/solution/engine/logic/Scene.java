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

        initialized = true;
        init();
        onSelected();
    }

    protected void requestSceneChange(String changeTo){
        manager.switchScene(changeTo);
    }

    public abstract void init();

    public abstract void update(float deltaTime);

    public abstract void onSelected();

    public void addGameObject(GameObject obj) {
        gameObjects.add(obj);

        if (!running)
            return;
    }

}
