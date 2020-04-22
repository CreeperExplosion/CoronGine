package solution.coronagame;

import solution.engine.gameobject.Creatures;
import solution.engine.input.Input;
import solution.engine.input.Keycode;
import solution.engine.graphics.Renderer;

public class Player extends Creatures {

    private float acceleratedSpeed = 40;
    private float normalSpeed = 30;

    public Player() {
        super("/test.png");
    }

    @Override
    public void init() {

        x = 0;
        y = 0;
        scale = 1;

        texture = spriteSheet.get(2);
    }

    @Override
    public void render(Renderer renderer) {
        float x1 = - (float) renderer.getRenderDimension().getWidth()/2f;
        float y1 = - (float) renderer.getRenderDimension().getHeight()/2f;
        //renderer.drawImage(spriteSheet.get(1),  0 ,  0, -1 ,2);
        

        renderer.drawImage(texture,x-8, y-8, 0, scale);
        
        
    } 
    
    @Override
    public void update(float deltaTime) {

        if (Input.getKeyDown(Keycode.D)) {
            x -= normalSpeed * deltaTime;
        }
        if(Input.getKeyHeld(Keycode.D)){
            x -= acceleratedSpeed * deltaTime;
        }

        if (Input.getKeyDown(Keycode.A)) {
            x += normalSpeed * deltaTime;
        }
        if(Input.getKeyHeld(Keycode.A)){
            x += acceleratedSpeed * deltaTime;
        }

        if(Input.getKeyDown(Keycode.W)){
            y += normalSpeed* deltaTime;
        }
        if(Input.getKeyHeld(Keycode.W)){
            y += acceleratedSpeed * deltaTime;
        }
        if(Input.getKeyDown(Keycode.S)){
            y -= normalSpeed * deltaTime;
        }
        if(Input.getKeyHeld(Keycode.S)){
            y -= acceleratedSpeed * deltaTime;
        }

        System.out.println(x + "" + y);


    }

}