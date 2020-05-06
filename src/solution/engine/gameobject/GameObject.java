package solution.engine.gameobject;

import java.util.LinkedList;
import java.util.List;

public class GameObject {
    
    List<Component> components;

    public GameObject() {
        components = new LinkedList<>();
    }

    public void addComponent(Component component){
        component.gameObject = this;
        components.add(component);
    }

    public<T extends Component> T getComponent(Class<T> componentClass){
        for (Component component : components) {
            if(componentClass.isAssignableFrom(component.getClass())){
                return componentClass.cast(component);
            }
        }
        return null;
    } 

    public <T extends Component> void removeComponent(Class<T> componentClass){
        
        for (Component component : components) {
            if(componentClass.isAssignableFrom(component.getClass())){
                components.remove(component);
                return;
            }
        }
    }

    public void update(float deltaTime){
        for (Component component : components) {
            component.update(deltaTime);
        }
    }
}