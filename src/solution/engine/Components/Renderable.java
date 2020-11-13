package solution.engine.Components;

import java.awt.image.*;
import java.io.IOException;

import solution.engine.gameobject.Component;
import solution.engine.graphics.ImageLoader;

public class Renderable extends Component {

	public boolean render;
	public BufferedImage image;

	public Renderable(String pathToImage) {
		setImage(pathToImage);
	}

	/**
	 * need to have Spritesheet
	 */
	public Renderable() {
		setImage("/test.png");
	}

	private void setImage(String pathToImage) {
		try {
			image = ImageLoader.loadImage(pathToImage);
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

	@Override
	public void init() {
		render = true;
	}

	@Override
	public void update(float deltaTime) {
		if (!render)
			return;

		gameObject.scene.renderer.drawImage(image, gameObject.position.x, gameObject.position.y, gameObject.z,
				gameObject.scale);
	}

}