package solution.engine.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.geom.AffineTransform;

public class Renderer {

    public static final int Z_LAYERS_NUMBER = 3;
    ArrayList<HashSet<RenderObject>> zLayers;
    float yScale;
    float xScale;
    Dimension renderDimension;

    Camera camera;


    public Renderer(int rendererSizeX, int rendererSizeY, Window window) {

        xScale = window.getWidth() / rendererSizeX;
        yScale = window.getHeight() / rendererSizeY;

        renderDimension = new Dimension(rendererSizeX, rendererSizeY);

        zLayers = new ArrayList<HashSet<RenderObject>>(3);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }
        camera = null;
    }

    public void render(Graphics screen, Window window) {

        Graphics2D screen2D = (Graphics2D) screen;

        xScale = (float) (window.getWidth() / renderDimension.getWidth());
        yScale = (float) (window.getHeight() / renderDimension.getHeight());

        AffineTransform oldAT = screen2D.getTransform();


        // setting world coordinates to screen
        screen2D.translate(window.getWidth()/2, window.getHeight()/2);
        screen2D.scale(xScale, yScale);

        // camera transformation
        screen2D.translate(camera.getX(), camera.getY());
        screen2D.scale(camera.getZoom(), camera.getZoom());

        screen2D.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        screen2D.setRenderingHint(
                RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY);
        screen2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, 
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);      

        for (HashSet<RenderObject> zLayer : zLayers) {
            for (RenderObject renderObject : zLayer) {
                AffineTransform at = screen2D.getTransform();
                screen2D.translate(renderObject.posX, renderObject.posY);
                screen2D.drawImage(renderObject.image, 0, 0, null);

                screen2D.setTransform(at);
            }
        }
        
        

        screen2D.setTransform(oldAT);
        cleanup();
    }

    public void drawImage(BufferedImage image, float posX, float posY, int z) {
        z = z + 1;

        RenderObject obj = new RenderObject(image, posX, posY);

        HashSet<RenderObject> thisLayer = zLayers.get(z);
        thisLayer.add(obj);
        zLayers.set(z, thisLayer);

    }

    public void drawImage(BufferedImage image, float x, float y) {
        this.drawImage(image,  x, y, 0);
    }

    private void cleanup() {
        zLayers = new ArrayList<HashSet<RenderObject>>(Z_LAYERS_NUMBER);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }

        camera = null;
    }

    public void setCamera(Camera camera){
        this.camera = camera;
    }
    /**
     * @return the renderDimension
     */
    public Dimension getRenderDimension() {
        return renderDimension;
    }

    class RenderObject {
        float posX;
        float posY;
        BufferedImage image;

        RenderObject(BufferedImage image, float posX, float posY) {
            this.posX = posX;
            this.posY = posY;

            this.image = image;
        }
    }
}