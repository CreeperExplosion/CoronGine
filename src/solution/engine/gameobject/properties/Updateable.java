package solution.engine.gameobject.properties;

import java.util.LinkedHashSet;

public interface Updateable {

    public static LinkedHashSet<Updateable> UPDATEABLES = new LinkedHashSet<Updateable>();

    public void update(float deltaTime);


    public default boolean startUpdate(){
        return UPDATEABLES.add(this);
    }

    public default boolean stopUpdate(){
        return UPDATEABLES.add(this);
    }


}