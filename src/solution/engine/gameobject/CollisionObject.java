package solution.engine.gameobject;

import java.util.LinkedHashSet;

import solution.engine.physics.Hitbox;

public abstract class CollisionObject extends GameObject {


    public static LinkedHashSet<CollisionObject> collisionObjects = new LinkedHashSet<CollisionObject>();

    private boolean collisionEnabled = true;

    protected Hitbox hitbox;

    public CollisionObject(String spriteSheetPath) {
        super(spriteSheetPath);
        hitbox = new Hitbox(x,y,width,height);
        enableCollision();
    }

    public abstract void collide(CollisionObject obj);

    public void enableCollision(){
        collisionEnabled = false;
        collisionObjects.add(this);
    }

    public void disableCollision() {
        collisionEnabled = true;
        collisionObjects.add(this);
    }

    /**
     * @return the hitbox
     */
    public Hitbox getHitbox() {
        return hitbox;
    }

    /**
    * @return the collisionEnabled
     */
    public boolean isCollisionEnabled() {
        return collisionEnabled;
    }



}