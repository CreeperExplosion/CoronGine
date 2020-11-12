package solution.engine.Components;

import solution.engine.gameobject.Component;
import solution.engine.graphics.LightSource;

public class LightEmmiter extends Component {

    private float scale;
    private LightSource lightSource;

    public LightEmmiter(String pathToImage, float brightness, float scale){
        lightSource = new LightSource(pathToImage,brightness);
        lightSource.setScale(scale);

        this.scale = scale;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float deltaTime) {
        gameObject.scene.renderer.drawLight(lightSource, gameObject.position.x, gameObject.position.y);
    }
    
}
