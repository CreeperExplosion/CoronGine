package solution.engine.physics;

import solution.engine.gameobject.CollisionObject;

public class CollisionHandler {

    public CollisionHandler() {
        super();
    }

    public void update() {
        for (CollisionObject obj : CollisionObject.collisionObjects) {

            for (CollisionObject obj1 : CollisionObject.collisionObjects) {

                    if (obj.getHitbox().intersects(obj1.getHitbox())) {
                        obj.collide(obj1);
                    }
            }
        }
    }

}