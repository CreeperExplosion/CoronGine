package solution.engine.gameobject;

import java.util.LinkedList;
import java.util.List;

import solution.engine.logic.Scene;

public final class GameObject {

    public List<Component> components;

    public Scene scene;

    public GameObject() {
        components = new LinkedList<>();
    }

    public GameObject(final Component... components) {
        addComponents(components);
    }

    public void addComponents(final Component... components) {
        for (final var comp : components) {

            this.components.add(comp);
            comp.gameObject = this;
            comp.start();
        }
    }

    public <T extends Component> T getComponent(final Class<T> componentClass) {
        for (final var component : components) {
            if (componentClass.isAssignableFrom(component.getClass())) {
                return componentClass.cast(component);
            }
        }
        return null;
    }

    public <T extends Component> void removeComponent(final Class<T> componentClass) {
        for (final var component : components) {
            if (componentClass.isAssignableFrom(component.getClass())) {
                components.remove(component);
            }
        }
    }

    public void update(final float deltaTime, Scene scene) {
        this.scene = scene;
        for (final var component : components) {
            component.update(deltaTime);
        }
    }
}