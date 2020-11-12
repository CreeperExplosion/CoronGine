package solution.engine.graphics;

import java.awt.image.*;
import java.io.IOException;
import java.awt.*;

public class LightSource {

    BufferedImage lightImage;
    float brightness;
    float x,y;
    float scale;
    public LightSource(String pathToImage, float brightness) {

        this.brightness = brightness;
        try {
            lightImage = ImageLoader.loadImage(pathToImage);
        } catch (IOException e){
            e.printStackTrace();
        }
        
        scale = 1 ;
    }

    public void setScale(float scale){
        this.scale = scale;
    }

    /**
     * @return the lightImage
     */
    BufferedImage getLightImage() {
        return lightImage;
    }


    void render(Graphics2D graphics2d){
        graphics2d.drawImage(lightImage, 0, 0, null);
    }
}