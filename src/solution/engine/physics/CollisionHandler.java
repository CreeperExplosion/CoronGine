package solution.engine.physics;

import java.util.Vector;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.CollisionObject;

public class CollisionHandler {

    public CollisionHandler() {
        super();
    }

    public void update() {
        for (CollisionObject obj1 : CollisionObject.collisionObjects) {
            if (obj1.getHitbox() == null)
                continue;
            for (CollisionObject obj2 : CollisionObject.collisionObjects) {
                if (obj2.getHitbox() == null)
                    continue;

                if (obj1.equals(obj2))
                    continue;

                Hitbox hitbox1 = obj1.getHitbox();
                Hitbox hitbox2 = obj2.getHitbox();

                if (hitbox1.intersects(hitbox2)) {

                    Vector2f direction = new Vector2f();

                    direction.x = hitbox2.getX() - hitbox1.getX();
                    direction.y = hitbox2.getY() - hitbox1.getY();

                    direction = direction.toUnit();
                    obj1.collide(obj2, direction);
                }

            }
        }
    }

}