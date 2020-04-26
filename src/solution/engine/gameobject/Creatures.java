package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;
import solution.engine.gameobject.properties.Updateable;

public abstract class Creatures extends CollisionObject implements Renderable, Updateable {

    public Creatures(String path) {
        super(path);
    }

    public void moveX(float dx) {
        x += dx;
    }

    public void moveY(float dy) {
        y += dy;
    }
}