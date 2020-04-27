package solution.coronagame;

import solution.engine.gameobject.Tile;

public class Grass extends Tile{

    public Grass() {
        super("/test.png");
    }

    @Override
    public void init() {
        texture = spriteSheet.get(0);
    }

    @Override
    public void update(float deltaTime) {
    }

    public void setIndex(int i){
        texture = spriteSheet.get(i);
    }

}   