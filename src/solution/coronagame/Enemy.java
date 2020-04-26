package solution.coronagame;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.CollisionObject;
import solution.engine.gameobject.Creatures;
import solution.engine.graphics.Renderer;

public class Enemy extends Creatures {

    public Enemy() {
        super("/test.png");
    }

    @Override
    public void render(Renderer renderer) {
        renderer.drawImage(spriteSheet.get(0), x, y,0);

        
        //renderer.drawImage(spriteSheet.get(2), getHitbox().getX(), getHitbox().getY(), 1, 1);

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void collide(CollisionObject obj, Vector2f dir) {

    }

    @Override
    public void init() {

    }
}