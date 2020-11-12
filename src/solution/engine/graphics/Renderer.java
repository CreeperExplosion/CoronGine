package solution.engine.graphics;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.HashSet;

import solution.engine.gameobject.GameObject;

import java.awt.geom.AffineTransform;

public class Renderer {

    public static final int Z_LAYERS_NUMBER = 3;
    float yScale;
    float xScale;
    float rendererHeight, rendererWidth;

    Camera camera;
    ArrayList<HashSet<RenderObject>> zLayers;
    WorldLighting worldLight;

    ArrayList<LightSource> lightSources;

    private float worldLightLevel = 0f;

    public Renderer(int rendererSizeX, int rendererSizeY, Window window) {

        // setup the scale of the window
        xScale = window.getWidth() / rendererSizeX;
        yScale = window.getHeight() / rendererSizeY;
        rendererWidth = rendererSizeX;
        rendererHeight = rendererSizeY;

        zLayers = new ArrayList<HashSet<RenderObject>>(3);
        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }  

       

        camera = new Camera(1, 0, 0);
        lightSources = new ArrayList<LightSource>();
        worldLight = new WorldLighting(rendererSizeX, rendererSizeY);
    }

    /**
     * render every render objects that were added
     * 
     * render steps:
     * <ol>
     * <li>set image Quality
     * <li>scale from render space to screen space
     * <li>tanslate and scale according to camera
     * <li>render every object that is not culled
     * <li>render every light that is not culled
     * </ol>
     * <br>
     * 
     * @param screen
     * @param window
     */
    public void render(Graphics2D screen2D, Window window) {
        AffineTransform oldAT = screen2D.getTransform();

        //
        // GRPHICS QUALITY
        //
        screen2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        screen2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        screen2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);

        //
        // setup the scales
        //
        xScale = (float) (window.getWidth() / rendererWidth);
        yScale = (float) (window.getHeight() / rendererHeight);

        //
        // setting render size to screen screen size
        //
        screen2D.scale(xScale, yScale);
        screen2D.translate(rendererWidth / 2, rendererHeight / 2);

        //
        // camera transformation
        //
        screen2D.scale(camera.getZoom(), camera.getZoom());
        screen2D.translate(-camera.getX(), -camera.getY());

        //
        // drawing each objects
        //
        for (HashSet<RenderObject> zLayer : zLayers) {

            for (RenderObject renderObject : zLayer) {

                AffineTransform at = screen2D.getTransform();
                screen2D.translate(renderObject.posX, renderObject.posY);
                screen2D.scale(renderObject.scalex, renderObject.scaley);
                screen2D.drawImage(renderObject.image, 0, 0, null);
                screen2D.setTransform(at);

            }
        }
        screen2D.setTransform(oldAT);
        // render the lights
        screen2D.scale(xScale, yScale);
        worldLight.render(screen2D);
    }

    public void renderLight() {
        worldLight.reset();

        worldLight.setLightlevel(worldLightLevel);
        worldLight.setLightlevel(worldLightLevel);
        worldLight.renderLight(camera, lightSources);
    }

    /**
     * create a rectangular image and add that to renderobjet to render later
     * 
     * @param x      x position of top left corner
     * @param y      y position of top left corner
     * @param width
     * @param height
     * @param z      z layer
     * @param color  color in hex
     */
    public void drawRec(float x, float y, float width, float height, int z, int color) {
        z = z + 1;
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        int[] col = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        for (int i = 0; i < col.length; i++) {
            col[i] = color;
        }
        RenderObject obj = new RenderObject(img, x, y, width, height);

        HashSet<RenderObject> thisLayer = zLayers.get(z);
        thisLayer.add(obj);
        zLayers.set(z, thisLayer);
    }

    /**
     * add image to renderobjects to render later
     * 
     * @param image
     * @param posX  top left corner
     * @param posY  top left corner
     * @param z
     * @param scale
     */
    public void drawImage(BufferedImage image, float posX, float posY, int z, float scale) {
        if (shouldCull(posX, posY, scale * 16f)) {
            return;
        }

        z = z + 1;

        RenderObject obj = new RenderObject(image, posX, posY, scale, scale);

        zLayers.get(z).add(obj);
    }

    public void drawImage(BufferedImage image, float x, float y, int z) {
        this.drawImage(image, x, y, z, 1);
    }

    public void drawImage(BufferedImage image, float x, float y) {
        this.drawImage(image, x, y, 0, 1);
    }

    /**
     * @param lightSource
     * @param posX
     * @param posY
     */
    public void drawLight(LightSource lightSource, float posX, float posY) {
        if (shouldCull(posX, posY, lightSource.scale * 16))
            return;

        lightSources.add(lightSource);
    }

    /**
     * determine if the object trying to be drawn is outside the screen
     * 
     * @param posX
     * @param posY
     * @param offset how far off the screen before it gets culled
     * @return whether to cull or not
     */
    private boolean shouldCull(float posX, float posY, float offset) {

        float x = camera.getX();
        float y = camera.getY();
        float zoom = camera.getZoom();

        float edgeL = (x - (float) rendererWidth / (2f * zoom)) - offset;
        float edgeR = (x + (float) rendererWidth / (2f * zoom));

        float edgeU = (y - (float) rendererHeight / (2f * zoom)) - offset;
        float edgeD = (y + (float) rendererHeight / (2f * zoom));

        return (posY < edgeU || posY > edgeD) || (posX < edgeL || (posX) > edgeR);
    }

    /**
     * revert everything for each frame;
     */
    public void cleanup() {
        zLayers = new ArrayList<HashSet<RenderObject>>(Z_LAYERS_NUMBER);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }

        lightSources = new ArrayList<LightSource>();
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setWorldLightLevel(float worldLightLevel) {

        this.worldLightLevel = worldLightLevel;
    }

    private class RenderObject {
        float posX;
        float posY;
        float scalex;
        float scaley;
        BufferedImage image;

        RenderObject(BufferedImage image, float posX, float posY, float scalex, float scaley) {
            this.scaley = scaley;
            this.scalex = scalex;
            this.posX = posX;
            this.posY = posY;

            this.image = image;
        }
    }
}