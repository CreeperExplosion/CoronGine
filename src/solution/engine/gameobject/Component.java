package solution.engine.gameobject;

public abstract class Component {
    public GameObject gameObject = null;

    protected boolean initialized = false;

    public void start() {
        if (initialized)
            return;

        init();
        initialized = true;
    }

    public abstract void init();

    public abstract void update(float deltaTime);
}