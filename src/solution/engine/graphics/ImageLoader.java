package solution.engine.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage loadImage(String path) throws IOException {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
