package solution.coronagame;


import solution.engine.Util.Timer;
import solution.engine.logic.GameImplementation;


public class CoronaGame extends GameImplementation {

    Player player;

    Timer timer;

    @Override
    public void update(float deltaTime) {
        camera.setX( - player.getX());
        camera.setY( - player.getY());
    }

    @Override
    public void init() {
        player = new Player();
       // player.stopRender();
    }

}