package solution.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;

public class Renderer {

    public static final int Z_LAYERS_NUMBER = 3;
    ArrayList<HashSet<RenderObject>> zLayers;


    public Renderer() {

        zLayers = new ArrayList<HashSet<RenderObject>>(3);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }

        System.out.println(zLayers.size());
    }


    public void render(Graphics screen) {
        Graphics2D graph2d =(Graphics2D) screen;
        for ( HashSet<RenderObject> zLayer : zLayers) {
            for (RenderObject renderObject : zLayer) {
                graph2d.drawImage(renderObject.image, renderObject.posX, renderObject.posY, null);
            }
        }

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