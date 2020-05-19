package solution.engine.logic;

import java.util.HashMap;

import solution.engine.gameobject.GameObject;

public abstract class SceneManager {

    protected Scene currentScene = new EmptyScene();

    public abstract void init();

    HashMap<String, Scene> scenes = new HashMap<>();

    HashMap<String, GameObject> ascendedObjects = new HashMap<>();

    public void update(float deltaTime) {
        currentScene.update(deltaTime);
    }

    protected void setScene(Scene scene) {
        scene.start(this);
        currentScene = scene;
    }

    protected void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    void switchScene(String name) {
        currentScene = scenes.get(name);
    }

    /**
     * @return the currentScene
     */
    public Scene getCurrentScene() {
        return currentScene;
    }

    class EmptyScene extends Scene {
        @Override
        public void init() {
        }

        @Override
        public void update(float deltaTime) {
            System.out.println("Please Add Scene");
        }

        @Override
        public void onSelected() {
        }

    }
}