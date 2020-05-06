package solution.engine.logic;


public abstract class GameImplementation {

    
    protected Scene currentScene;

    public abstract void init();
    public abstract void update(float deltaTime);

    protected void setScene(Scene scene){
        scene.init();
        currentScene = scene;
    }

    /**
     * @return the currentScene
     */
    public Scene getCurrentScene() {
        return currentScene;
    }
}