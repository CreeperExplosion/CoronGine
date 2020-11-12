package solution.engine.graphics;

import java.awt.image.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;

public class WorldLighting {

    float lightlevel = 0f;

    BufferedImage worldLight;
    int width, height;

    WorldLighting(int width, int height) {
        this.height = height;
        this.width = width;

        worldLight = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    void renderLight(Camera cam, ArrayList<LightSource> lightSources) {
        var lightGraphics = (Graphics2D) worldLight.getGraphics();
        var bf = lightGraphics.getTransform();

        //
        // set light quality
        lightGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        lightGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        lightGraphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);

        //
        // setting the world's light colo

        var lColor = new Color(0, 0, 0, 1 - lightlevel);

        lightGraphics.setColor(lColor);
        lightGraphics.fillRect(0, 0, width, height);

        //
        // setting camera transform
        lightGraphics.translate(((float) width) / 2, ((float) height) / 2); 
        lightGraphics.scale(cam.getZoom(), cam.getZoom());
        lightGraphics.translate(-cam.getX(), -cam.getY());

        //
        // setting how the light should be drawn
        var comp = AlphaComposite.getInstance(AlphaComposite.DST_IN);
        lightGraphics.setComposite(comp);

        //
        // drawing each light with their transform
        for (LightSource lightSource : lightSources) {
            AffineTransform af = lightGraphics.getTransform();

            lightGraphics.scale(lightSource.scale, lightSource.scale);
            lightGraphics.translate(lightSource.x, lightSource.y);
            lightSource.render(lightGraphics);

            lightGraphics.setTransform(af);
        }

        lightGraphics.setTransform(bf);
        lightGraphics.dispose();
    }

    /**
     * @return the worldLight
     */
    BufferedImage getWorldLight() {
        return worldLight;
    }

    void reset() {
        // TODO to slow for comfort
        // this creates a new object, leaving the garbage collector to erase the old one.
        // which is SLOW
        worldLight = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    void render(Graphics2D graphics) {
        graphics.drawImage(worldLight, 0, 0, null);
    }

    /**
     * @param lightlevel the lightlevel to set
     */
    public void setLightlevel(float lightlevel) {
        this.lightlevel = lightlevel;
    }

}