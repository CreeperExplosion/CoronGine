package solution.Game.gameobject;

import java.awt.Graphics2D;

public abstract class GameObject {

    public float x;
    public float y;

    public GameObject() {
        this.init();
    }


    public abstract void init();

    public abstract void render(Graphics2D graphics);

    public abstract void update(float deltaTime);

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }
    /**
     * @return the y
     */
    public float getY() {
        return y;
    }
}