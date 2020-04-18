package solution.engine.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.geom.AffineTransform;

public class Renderer {

    public static final int Z_LAYERS_NUMBER = 3;
    ArrayList<HashSet<RenderObject>> zLayers;
    Graphics2D world;
    float yScale;
    float xScale;
    Dimension renderDimension;


    boolean showCalibration =true;

    public Renderer(int rendererSizeX, int rendererSizeY, Window window) {

        xScale = window.getWidth() / rendererSizeX;
        yScale = window.getHeight() / rendererSizeY;

        renderDimension = new Dimension(rendererSizeX, rendererSizeY);

        zLayers = new ArrayList<HashSet<RenderObject>>(3);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }
    }

    public void render(Graphics screen, Window window) {

        Graphics2D screen2D = (Graphics2D) screen;

        xScale = (float) (window.getWidth() / renderDimension.getWidth());
        yScale = (float) (window.getHeight() / renderDimension.getHeight());

        AffineTransform oldAT = screen2D.getTransform();

        screen2D.scale(xScale, yScale);

        for (HashSet<RenderObject> zLayer : zLayers) {
            for (RenderObject renderObject : zLayer) {
                screen2D.drawImage(renderObject.image, renderObject.posX, renderObject.posY, null);
            }
        }

        if(showCalibration){
            screen2D.setColor(Color.BLUE);
            screen2D.drawOval((int) (renderDimension.getWidth()-6) / 2, (int) (renderDimension.getHeight()-6) / 2, 6, 6);
            screen2D.drawOval(-3, -3, 6, 6);
            screen2D.drawOval((int) (renderDimension.getWidth()-3), (int) (renderDimension.getHeight()-2.6), 6, 6);
            screen2D.drawOval((int) (renderDimension.getWidth()-3), 0-3, 6, 6);
            screen2D.drawOval(0-3, (int) (renderDimension.getHeight()-3), 6, 6);
    
    
            screen2D.drawLine((int)renderDimension.getWidth()/2, 0, (int)renderDimension.getWidth()/2, (int)renderDimension.getHeight());
            screen2D.drawLine(0, (int)renderDimension.getHeight()/2, (int)renderDimension.getWidth(), (int)renderDimension.getHeight()/2);
        }
        

        screen2D.setTransform(oldAT);

        cleanup();
    }

    public void drawImage(BufferedImage image, int posX, int posY, int z) {
        z = z + 1;

        RenderObject obj = new RenderObject(image, posX, posY);

        HashSet<RenderObject> thisLayer = zLayers.get(z);
        thisLayer.add(obj);
        zLayers.set(z, thisLayer);

    }

    public void drawImage(BufferedImage image, float x, float y, int z) {
        this.drawImage(image, (int) x, (int) y, z);
    }

    public void drawImage(BufferedImage image, float x, float y) {
        this.drawImage(image, (int) x, (int) y, 0);
    }

    private void cleanup() {
        zLayers = new ArrayList<HashSet<RenderObject>>(Z_LAYERS_NUMBER);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }
    }

    /**
     * @param showCalibration the showCalibration to set
     */
    public void setShowCalibration(boolean showCalibration) {
        this.showCalibration = showCalibration;
    }

    /**
     * @return the renderDimension
     */
    public Dimension getRenderDimension() {
        return renderDimension;
    }

    class RenderObject {
        int posX;
        int posY;
        BufferedImage image;

        RenderObject(BufferedImage image, int posX, int posY) {
            this.posX = posX;
            this.posY = posY;

            this.image = image;
        }
    }
}