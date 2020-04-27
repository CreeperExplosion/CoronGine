package solution.engine.assets;

import solution.engine.graphics.ImageLoader;
import solution.engine.graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
    public static SpriteSheet spriteSheet;

    static {
        try {
            spriteSheet = new SpriteSheet(ImageLoader.loadImage("/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static BufferedImage desert = spriteSheet.get(0) , grass = spriteSheet.get(1);
}
