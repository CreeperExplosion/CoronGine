package solution.coronagame;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.Body;
import solution.engine.gameobject.Creatures;

public class Enemy extends Creatures {

    public Enemy() {
        super("/test.png");
    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void collide(Body obj, Vector2f dir) {

    }

    @Override
    public void init() {
        texture = spriteSheet.get(0);
        x = 32;
        y = 32;
        scale =1 ;
    }
}