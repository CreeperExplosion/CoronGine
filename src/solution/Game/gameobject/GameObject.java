package solution.Game.gameobject;

import java.awt.Graphics2D;

public abstract class GameObject {

    public int x;
    public int y;


    public abstract void init();

    public abstract void render(Graphics2D graphics);

    public abstract void update();

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
}