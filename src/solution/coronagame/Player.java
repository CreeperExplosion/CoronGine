package solution.coronagame;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.Body;
import solution.engine.gameobject.Creatures;
import solution.engine.input.Input;
import solution.engine.input.Keycode;

public class Player extends Creatures {

    private final float acceleratedSpeed = 40;
    private final float normalSpeed = 30;

    public Player() {
        super("/test.png");
    }

    public Player(float x , float y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void init() {
        
        disableCollision();
        x = 0;
        y = 0;
        scale = 1;

        texture = spriteSheet.get(0);

    }
    
    @Override
    public void update(final float deltaTime) {
        
        if (Input.getKeyDown(Keycode.D)) {
            x += normalSpeed * deltaTime;
        }
        if (Input.getKeyHeld(Keycode.D)) {
            x += acceleratedSpeed * deltaTime;
        }

        if (Input.getKeyDown(Keycode.A)) {
            x -= normalSpeed * deltaTime;
        }
        if (Input.getKeyHeld(Keycode.A)) {
            x -= acceleratedSpeed * deltaTime;
        }

        if (Input.getKeyDown(Keycode.W)) {
            y -= normalSpeed * deltaTime;
        }
        if (Input.getKeyHeld(Keycode.W)) {
            y -= acceleratedSpeed * deltaTime;
        }
        if (Input.getKeyDown(Keycode.S)) {
            y += normalSpeed * deltaTime;
        }
        if (Input.getKeyHeld(Keycode.S)) {
            y += acceleratedSpeed * deltaTime;
        }

    }

    @Override
    public void collide(Body obj, Vector2f direction) {
        
    }



}