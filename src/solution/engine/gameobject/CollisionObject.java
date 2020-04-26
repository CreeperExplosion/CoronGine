package solution.engine.gameobject;

import java.util.LinkedHashSet;

import solution.engine.Math.Vector2f;
import solution.engine.physics.Hitbox;

public abstract class CollisionObject extends GameObject {


    public static LinkedHashSet<CollisionObject> collisionObjects = new LinkedHashSet<CollisionObject>();

    private boolean collisionEnabled = true;

    {
        enableCollision();
    }

    public CollisionObject(String spriteSheetPath) {
        super(spriteSheetPath);
    }


    public abstract void collide(CollisionObject obj, Vector2f direction);


    public void enableCollision(){
        collisionEnabled = true;
        collisionObjects.add(this);
    }

    public void disableCollision() {
        collisionEnabled = false;
        collisionObjects.remove(this);
    }

    /**
     * @return the hitbox
     */
    public Hitbox getHitbox() {
        if (!collisionEnabled) 
            return null;

        return new Hitbox(x + (0.5f * width), y + (0.5f * height), width, height);
    }

    /**
    * @return the collisionEnabled
     */
    public boolean isCollisionEnabled() {
        return collisionEnabled;
    }



}