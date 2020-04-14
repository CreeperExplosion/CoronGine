package solution.Game.gameobject;

import java.awt.Graphics2D;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import solution.Game.input.Input;
import solution.Game.input.Keycode;
import solution.graphics.ImageLoader;
import solution.graphics.SpriteSheet;

public class Player extends GameObject {

    SpriteSheet spriteSheet;
    BufferedImage image;

    public Player() {
        try {
            image = ImageLoader.loadImage("/test.png");
            spriteSheet = new SpriteSheet(image);
            System.out.println("YES");
        } catch (IOException e) {
            System.out.println("NO");
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

        x = 0;
        y = 0;


    }

    @Override
    public void render(Graphics2D graphics) {

        graphics.setColor(Color.BLACK);
        graphics.drawImage(spriteSheet.get(3),x,y,null);

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