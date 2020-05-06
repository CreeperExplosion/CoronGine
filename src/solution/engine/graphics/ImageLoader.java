package solution.engine.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage loadImage(String path) throws IOException {

        BufferedImage img;
        try {
             img = ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e){
            throw new IOException(path + " could not be found");
        }

        return img;
    }
}
