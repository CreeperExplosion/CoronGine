package solution.engine.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    int x = 16;
    int y = 16;
    private BufferedImage[] crops = new BufferedImage[16];
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
        int index = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                crops[index] = crop(x*j, y*i, x,y);
                index++;
            }
        }
    }

    private BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }

    public BufferedImage get(int i){
        return crops[i];
    }

}
