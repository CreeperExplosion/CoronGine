package solution.engine.gameobject;

import java.util.LinkedHashSet;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.properties.Renderable;
import solution.engine.graphics.Renderer;
import solution.engine.physics.Hitbox;

public abstract class Body extends GameObject implements Renderable{

    protected int z;

    public static LinkedHashSet<Body> BODIES = new LinkedHashSet<Body>();

    private boolean collisionEnabled = true;

    {
        enableCollision();
    }

    public Body(String spriteSheetPath) {
        super(spriteSheetPath);

        z = 0;
    }

    public void render(Renderer renderer){
        renderer.drawImage(texture, x, y, z, scale);
    }

    public abstract void collide(Body obj, Vector2f direction);


    public void enableCollision(){
        collisionEnabled = true;
        BODIES.add(this);
    }

    public void disableCollision() {
        collisionEnabled = false;
        BODIES.remove(this);
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