package solution.coronagame;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.CollisionObject;
import solution.engine.gameobject.Creatures;
import solution.engine.input.Input;
import solution.engine.input.Keycode;
import solution.engine.graphics.Renderer;

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
        x = 64;
        y = 64;
        scale = 1;

        Vector2f v = new Vector2f(0, 1);


        System.out.println(Math.toDegrees(v.angleRad(new Vector2f(0, -1))));

        texture = spriteSheet.get(1);

    }
    
    @Override
    public void render(final Renderer renderer) {
        
        renderer.drawImage(texture, x, y, 0, scale);
        
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
    public void collide(CollisionObject obj, Vector2f direction) {
        
    }



}