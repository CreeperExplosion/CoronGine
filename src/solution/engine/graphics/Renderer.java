package solution.engine.graphics;

import java.awt.*;
import java.awt.image.*;
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
        camera = new Camera(1, 0, 0);
    }

    public void render(Graphics screen, Window window) {

        Graphics2D screen2D = (Graphics2D) screen;

        xScale = (float) (window.getWidth() / renderDimension.getWidth());
        yScale = (float) (window.getHeight() / renderDimension.getHeight());

        AffineTransform oldAT = screen2D.getTransform();

        // GRPHICS QUALITY
        screen2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        screen2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        screen2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);

        // setting world coordinates to screen
        // screen2D.translate(window.getWidth() / 2, window.getHeight() / 2);
        screen2D.scale(xScale, yScale);
        screen2D.translate(renderDimension.getWidth() / 2, renderDimension.getHeight() / 2);

        // camera transformation
        screen2D.scale(camera.getZoom(), camera.getZoom());
        screen2D.translate(camera.getX(), camera.getY());

        // drawing each objects
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
        cleanup();
    }

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

    public void drawImage(BufferedImage image, float posX, float posY, int z, float scale) {
        z = z + 1;

        float allowance = 16 * scale;

        float x = -camera.getX();
        float y = -camera.getY();
        float zoom = camera.getZoom();

        float edgeL = (x - (float) renderDimension.getWidth() / (2f * zoom)) - allowance;
        float edgeR = (x + (float) renderDimension.getWidth() / (2f * zoom));

        float edgeU = (y - (float) renderDimension.getHeight() / (2f * zoom)) - allowance;
        float edgeD = (y + (float) renderDimension.getHeight() / (2f * zoom));

        if (posX < edgeL || (posX) > edgeR)
            return;

        if (posY < edgeU || posY > edgeD)
            return;

        RenderObject obj = new RenderObject(image, posX, posY, scale, scale);

        HashSet<RenderObject> thisLayer = zLayers.get(z);
        thisLayer.add(obj);
        zLayers.set(z, thisLayer);

    }

    public void drawImage(BufferedImage image, float x, float y, int z) {
        this.drawImage(image, x, y, z, 1);
    }

    public void drawImage(BufferedImage image, float x, float y) {
        this.drawImage(image, x, y, 0, 1);
    }

    private void cleanup() {
        zLayers = new ArrayList<HashSet<RenderObject>>(Z_LAYERS_NUMBER);

        for (int i = 0; i < Z_LAYERS_NUMBER; i++) {
            zLayers.add(new HashSet<RenderObject>());
        }
    }

    public void setCamera(Camera camera) {
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