package solution.engine.gameobject;

public abstract class Component {
    public GameObject gameObject = null;

    public void start(){}

	public abstract void update(float deltaTime);
}