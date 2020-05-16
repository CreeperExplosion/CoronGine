package solution.engine.logic;

public abstract class SceneManager {

    protected Scene currentScene = new EmptyScene();

    public abstract void init();

    public void update(float deltaTime) {
        currentScene.update(deltaTime);
    }

    protected void setScene(Scene scene) {
        scene.start(this);
        currentScene = scene;
    }

    // TODO find a faster parameter than String
    protected abstract void switchScene(String changeTo);

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