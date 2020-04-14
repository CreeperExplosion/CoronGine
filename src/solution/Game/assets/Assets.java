package solution.Game.assets;

import solution.graphics.ImageLoader;
import solution.graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
    public static SpriteSheet spriteSheet;

    {
        try {
            spriteSheet = new SpriteSheet(ImageLoader.loadImage("/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static BufferedImage desert = spriteSheet.get(0) , grass = spriteSheet.get(1);
}
