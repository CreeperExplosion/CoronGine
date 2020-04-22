package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;
import solution.engine.gameobject.properties.Updateable;
import solution.engine.physics.Hitbox;

public abstract class Creatures extends GameObject implements Renderable, Updateable{

    protected Hitbox hitbox;
    public Creatures(String path) {
        super(path);

        hitbox = new Hitbox(x, y, 16, 16);

        startRender();
        startUpdate();
    }  

    public void moveX(float dx){
        x += dx;
    }
    public void moveY(float dy){
        y += dy;
    }

    /**
     * @return the hitbox
     */
    public Hitbox getHitbox() {
        return hitbox;
    }
}