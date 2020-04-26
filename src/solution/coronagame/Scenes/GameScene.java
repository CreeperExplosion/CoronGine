package solution.coronagame.Scenes;

import solution.coronagame.Grass;
import solution.coronagame.Player;
import solution.engine.gameobject.Tile;
import solution.engine.logic.Scene;

public class GameScene implements Scene {

    Player player;

    Tile[] world = new Grass[1000];

    public GameScene(Player pl) {
        player = pl;

        for (int i = 0; i < world.length; i++) {

            Grass g = new Grass();
            g.startRender();
            
            int twidth = 25;

            int x, y;

            x = i % twidth;

            y = (int)Math.floor(i / twidth);

            g.setX(x*16);
            g.setY(y*16);
            g.setIndex((int)(1 + Math.random() * 2));
            g.startRender();
            world[i]  = g;
        }

    }


    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);

        camera.setX( - player.getX());
        camera.setY( - player.getY());
        for (Tile tile : world) {
            tile.update(deltaTime);
        }
    }

}