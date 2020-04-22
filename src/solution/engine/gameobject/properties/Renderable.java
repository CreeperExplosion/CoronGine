package solution.engine.gameobject.properties;

import java.util.LinkedHashSet;

import solution.engine.graphics.Renderer;

public interface Renderable {

    public static LinkedHashSet<Renderable> RENDERABLES = new LinkedHashSet<Renderable>();

    
    public void render(Renderer renderer);

    public default boolean startRender(){
        return RENDERABLES.add(this);
    }

    public default boolean stopRender(){
        return RENDERABLES.remove(this);
    }

}