package solution.engine.Components;

import solution.engine.gameobject.Component;
import solution.engine.graphics.ImageLoader;
import solution.engine.graphics.SpriteSheet;

public class Sprite extends Component {

    SpriteSheet sheet;

    public int index;

    public Sprite(String pathToSheet) {

        try {
            var img = ImageLoader.loadImage(pathToSheet);
            sheet = new SpriteSheet(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

        index = 0;

    }

    @Override
    public void update(float deltaTime) {
        if (sheet == null)
            return;

        var sprite = sheet.get(index);

        gameObject.scene.renderer.drawImage(sprite,
                gameObject.position.x, gameObject.position.y, gameObject.z,
                gameObject.scale);
    }

}
