package solution.engine.gameobject;

import solution.engine.physics.Hitbox;

public abstract class Creatures extends GameObject {

    protected Hitbox hitbox;
    public Creatures(String path) {
        super(path);

        hitbox = new Hitbox(x, y, 16, 16);
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