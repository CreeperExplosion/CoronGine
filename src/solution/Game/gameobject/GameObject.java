package solution.Game.gameobject;

import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.IOException;

import solution.graphics.ImageLoader;
import solution.graphics.Renderer;
import solution.graphics.SpriteSheet;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected float height;
    protected float width;

    SpriteSheet spriteSheet;
    BufferedImage texture;

    public GameObject(String spriteSheetPath) {
        this.init();
        try {
            spriteSheet = new SpriteSheet(ImageLoader.loadImage(spriteSheetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        texture = spriteSheet.get(0);
    }

    public abstract void init();

    public abstract void render(Renderer renderer);

    public abstract void update(float deltaTime);

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }
    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}