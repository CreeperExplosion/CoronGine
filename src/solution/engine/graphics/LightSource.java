package solution.engine.graphics;

import java.awt.image.*;
import java.io.IOException;
import java.awt.*;

public class LightSource {

    BufferedImage lightStencil;
    BufferedImage lightColor;

    float brightness = 1f;
    float x,y;
    public float rot;
    public float scale;
    public LightSource(String pathToStencil, String pathToColor) {

        try {
            lightStencil = ImageLoader.loadImage(pathToStencil);
            lightColor = ImageLoader.loadImage(pathToColor);
        } catch (IOException e){
            e.printStackTrace();
        }
        
        scale = 1 ;
    }

    public void setScale(float scale){
        this.scale = scale;
    }

    public void setBrightness(float brightness){
        this.brightness = brightness;
    }

    /**
     * @return the lightImage
     */
    BufferedImage getLightStencil() {
        return lightStencil;
    }


    void stencil(Graphics2D graphics2d){
        graphics2d.drawImage(lightStencil, 0, 0, null);
    }

    void color(Graphics2D graphics2d){
        graphics2d.drawImage(lightColor, 0, 0, null);
    }
}