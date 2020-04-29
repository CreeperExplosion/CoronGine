package solution.engine.graphics;

import java.awt.image.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;






public class WorldLighting {

    private int color = 0x00000000;

    private int light;


    BufferedImage worldLight;
    int width, height;

    WorldLighting(int width, int height) {
        this.height = height;
        this.width = width;

        worldLight = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }


    void renderLight(Camera cam, ArrayList<LightSource> lightSources){
        Graphics2D lightGraphics =  (Graphics2D) worldLight.getGraphics();


        //set light quality
        lightGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        lightGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        lightGraphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);


        AffineTransform bf = lightGraphics.getTransform();
        lightGraphics.setColor(new Color(light << 24, true));
        lightGraphics.fillRect(0, 0, width, height);


        lightGraphics.translate(((float)width) /2, ((float)height)/2 );;
        lightGraphics.scale(cam.getZoom(), cam.getZoom());
        lightGraphics.translate(-cam.getX(), -cam.getY());

       


        for (LightSource lightSource : lightSources) {
            AffineTransform af = lightGraphics.getTransform();

            lightGraphics.scale(lightSource.scale, lightSource.scale);
            lightGraphics.translate(lightSource.x, lightSource.y);
            AlphaComposite comp = AlphaComposite.getInstance(AlphaComposite.DST_IN, lightSource.brightness);
            lightGraphics.setComposite(comp);
            lightSource.render(lightGraphics);
            //lightGraphics.drawImage(lightSource.getLightImage(), 0, 0, null);

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

    void reset(){
        //TODO find a faster way
        worldLight = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    void render(Graphics2D graphics){
        graphics.drawImage(worldLight, 0, 0, null);
    }

    /**
     * @param lightlevel the lightlevel to set
     */
    public void setLightlevel(int lightlevel) {
        light = lightlevel;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }

}   