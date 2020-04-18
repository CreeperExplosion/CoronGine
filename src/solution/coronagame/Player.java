package solution.coronagame;

import solution.engine.gameobject.Creatures;
import solution.engine.input.Input;
import solution.engine.input.Keycode;
import solution.engine.graphics.Renderer;

public class Player extends Creatures {

    public Player() {
        super("/test.png");
    }

    @Override
    public void init() {

        x = 0;
        y = 0;
        
    }

    @Override
    public void render(Renderer renderer) {
        float x1 = (float) renderer.getRenderDimension().getWidth()/2f;
        float y1 =  (float)renderer.getRenderDimension().getHeight()/2f;
        renderer.drawImage(spriteSheet.get(1),  x1- 8 ,  y1 - 8, 1);
        

        renderer.drawImage(texture,x, y, 0);
    }
    
    @Override
    public void update(float deltaTime) {

        if (Input.getKeyDown(Keycode.D)) {
            x += 30 * deltaTime;
        }
        if(Input.getKeyHeld(Keycode.D)){
            x += 40 * deltaTime;
        }

        if (Input.getKeyDown(Keycode.A)) {
            x -= 30 * deltaTime;
        }
        if(Input.getKeyHeld(Keycode.A)){
            x -= 40 * deltaTime;
        }

        if(Input.getKeyDown(Keycode.S)){
            y += 30 * deltaTime;
        }
        if(Input.getKeyDown(Keycode.W)){
            y -= 30* deltaTime;
        }
        if(Input.getKeyHeld(Keycode.S)){
            y += 40 * deltaTime;
        }
        if(Input.getKeyHeld(Keycode.W)){
            y -= 40 * deltaTime;
        }



    }

    public void move(){

    }



}