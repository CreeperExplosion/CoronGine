package solution.Game.gameobject;

import java.awt.Graphics2D;
import java.awt.*;

import solution.Game.input.Input;
import solution.Game.input.Keycode;

public class Player extends GameObject {

    @Override
    public void init() {
        x = 0;
        y = 0;
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        
        graphics.fillRect((int)x, (int)y, 10, 10);
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



    }

}