package solution.engine.gameobject;

import java.awt.image.*;
import java.io.IOException;

import solution.engine.graphics.ImageLoader;
import solution.engine.graphics.SpriteSheet;

public abstract class GameObject {


    protected float x, y, width, height, scale;

    protected SpriteSheet spriteSheet;
    protected BufferedImage texture;

    public GameObject(String spriteSheetPath) {
        try {
            spriteSheet = new SpriteSheet(ImageLoader.loadImage(spriteSheetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = 16;
        height = 16;
        scale = 1;
        texture = spriteSheet.get(0);
        this.init();
    }

    public abstract void init();

    public abstract void update(float deltaTime);
    /**
     * @param scale the scale to set
     */
    public void setScale(float scale) {
        this.scale = scale;
    }
    /**
     * @return the scale
     */
    public float getScale() {
        return scale;
    }
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