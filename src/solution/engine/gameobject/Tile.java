package solution.engine.gameobject;

import solution.engine.gameobject.properties.Renderable;
import solution.engine.graphics.Renderer;

public abstract class Tile extends GameObject implements Renderable {


    public final int Z = -1;

    public Tile(String spriteSheetPath) {
        super(spriteSheetPath);
    }

    @Override
    public void render(Renderer renderer) {
        renderer.drawImage(texture, x, y, Z, scale);
    }



}