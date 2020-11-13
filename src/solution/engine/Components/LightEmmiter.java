package solution.engine.Components;

import solution.engine.gameobject.Component;
import solution.engine.graphics.LightSource;
import solution.engine.input.Input;

public class LightEmmiter extends Component {

    private LightSource lightSource;

    public float scale = 1f;

    public LightEmmiter(String pathToImage, float brightness){
        lightSource = new LightSource(pathToImage, "/TestLightColor.png");

        setBrightness(brightness);
    }

    @Override
    public void init() {
        lightSource.setScale(gameObject.scale);
    }

    @Override
    public void update(float deltaTime) {

        lightSource.setScale(gameObject.scale * this.scale);

        gameObject.scene.renderer.drawLight(lightSource, 
        Input.mouseX() - 8 * lightSource.scale, Input.mouseY()- 8 * lightSource.scale);
    }

    public void setBrightness(float brightness){
        lightSource.setBrightness(brightness);
    }
    
}
