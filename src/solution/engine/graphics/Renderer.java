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
    double yScale;
    double xScale;
    Dimension renderDimension;
    public Renderer(int rendererSizeX, int rendererSizeY, Window window) {
        
        xScale = window.getWidth()/rendererSizeX;
        yScale =   window.getHeight()/rendererSizeY;

        renderDimension = new Dimension(rendererSizeX, rendererSizeY);

        zLayers = new ArrayList<HashSet<RenderObject>>(3);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }
    }


    public void render(Graphics screen, Window window) {
        Graphics2D screen2D = (Graphics2D) screen;
        
        xScale = window.getWidth()/renderDimension.getWidth();
        yScale = window.getHeight()/renderDimension.getHeight();

        AffineTransform oldAT = screen2D.getTransform();
        
        screen2D.scale(xScale, yScale);


        for ( HashSet<RenderObject> zLayer : zLayers) {
            for (RenderObject renderObject : zLayer) {
                screen2D.drawImage(renderObject.image, renderObject.posX, renderObject.posY, null);
            }
        }

        screen2D.setTransform(oldAT);

        cleanup();
    }


    public void drawImage(BufferedImage image, int posX, int posY, int z) {
        z = z+1;

        RenderObject obj = new RenderObject(image, posX, posY);
        
        HashSet<RenderObject> thisLayer = zLayers.get(z);
        thisLayer.add(obj);
        zLayers.set(z, thisLayer);

        
    }

    public void drawImage(BufferedImage image, float x, float y, int z){
        this.drawImage(image,(int) x, (int) y, z);
    }

    public void drawImage(BufferedImage image, float x, float y){
        this.drawImage(image,(int) x, (int) y, 0);
    }


    private void cleanup(){
        zLayers = new ArrayList<HashSet<RenderObject>>(Z_LAYERS_NUMBER);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }
    }

    class RenderObject{
        int posX;
        int posY;
        BufferedImage image;

        RenderObject (BufferedImage image, int posX, int posY){
            this.posX = posX;
            this.posY = posY;

            this.image = image;
        }
    }
}