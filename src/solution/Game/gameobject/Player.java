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
        graphics.fillRect(x, y, 50, 50);

    }

    @Override
    public void update() {
        
        if (Input.getKeyDown(Keycode.D)) {
            x += 5;
        }
        if(Input.getKeyHeld(Keycode.D)){
            x += 10;
        }

        if (Input.getKeyDown(Keycode.A)) {
            x -= 5;
        }
        if(Input.getKeyHeld(Keycode.A)){
            x -= 10;
        }

        if(Input.getKeyDown(Keycode.S)){
            y += 5;
        }
        if(Input.getKeyDown(Keycode.W)){
            y -= 5;
        }
        if(Input.getKeyHeld(Keycode.S)){
            y += 10;
        }
        if(Input.getKeyHeld(Keycode.W)){
            y -= 10;
        }



    }

    public void move(){

    }



}