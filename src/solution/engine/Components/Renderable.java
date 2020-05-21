package solution.engine.Components;

import solution.engine.gameobject.Component;

public class Renderable extends Component {

	public boolean render;

	public Renderable() {

	}

	@Override
	public void init() {
		render = true;
	}

	@Override
	public void update(float deltaTime) {
		if (!render)
			return;

		

	}

}