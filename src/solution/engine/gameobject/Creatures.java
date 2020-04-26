package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;

public abstract class Creatures extends Body {

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