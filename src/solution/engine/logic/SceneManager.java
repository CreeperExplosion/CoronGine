package solution.engine.logic;

import java.util.HashMap;

import solution.engine.gameobject.GameObject;

public abstract class SceneManager {

    protected Scene currentScene = new EmptyScene();

    HashMap<String, Scene> scenes = new HashMap<>();

    protected HashMap<String, GameObject> ascendedObjects = new HashMap<>();

    public void update(float deltaTime) {
        currentScene.update(deltaTime);
    }

    public abstract void init();

    protected void setScene(String name) {
        currentScene.running = false;
        // // // // // // // // // //
        var scene = scenes.get(name);
        scene.start(this);
        currentScene = scene;
        currentScene.running = true;




    }

    protected void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    
    }

    void switchScene(String name) {
        currentScene = scenes.get(name);
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    class EmptyScene extends Scene {
        @Override
        public void init() {
        }

        @Override
        public void update(float deltaTime) {
            System.out.println("Please Select a scene");
        }

        @Override
        public void onSelected() {
        }

    }
}