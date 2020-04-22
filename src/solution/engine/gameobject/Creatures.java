package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;
import solution.engine.gameobject.properties.Updateable;
import solution.engine.physics.Hitbox;

public abstract class Creatures extends CollisionObject implements Renderable, Updateable{

    public Creatures(String path) {
        super(path);

        hitbox = new Hitbox(x, y, 16, 16);

        startRender();
        startUpdate();
    }  

    public void moveX(float dx){
        x += dx;
        hitbox.movex(dx);
    }
    public void moveY(float dy){
        y += dy;
        hitbox.moveY(dy);
    }

    /**
     * @return the hitbox
     */
    public Hitbox getHitbox() {
        return hitbox;
    }
}