package solution.coronagame;

import solution.engine.logic.GameImplementation;
import solution.engine.physics.Hitbox;

import java.awt.Color;

import solution.engine.graphics.Renderer;
import solution.engine.input.Input;

public class CoronaGame implements GameImplementation {

    Player player;
    float cameraZoom;
    int flipper = 1;
    @Override
    public void render(Renderer renderer) {
       player.render(renderer);

       //renderer.drawRec(Input.mouseX(), Input.mouseY(), 32, 32, 0, Color.RED.getRGB());

       //System.out.println(Input.mouseX());

       
       
    }

    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);
        camera.setX( - player.getX());
        camera.setY( - player.getY());

        
    //     boolean yes = player.getHitbox().intersects(new Hitbox(Input.mouseX(), Input.mouseY(), 3, 3));
    //    System.out.println(yes);
    }

    @Override
    public void init() {
        player = new Player();
    }

}