package solution.engine.Components;

import solution.engine.Math.Vector2f;
import solution.engine.gameobject.Component;
import solution.engine.input.Input;
import solution.engine.input.Keycode;

public class Controller extends Component {


    boolean hasMovable;

    public Controller(){

    }

    @Override
    public void init() {
        gameObject.position.x = 1;
        gameObject.position.y = 1;

    }

    @Override
    public void update(float deltaTime) {
        // TODO change, this is ugly
        var left = Input.getKeyHeld(Keycode.A);
        var right = Input.getKeyHeld(Keycode.D);
        var up = Input.getKeyHeld(Keycode.W);
        var down = Input.getKeyHeld(Keycode.S);

        // System.out.println("left");
        float hor = 0f;
        if (left){
            hor -= 1f;
        }
        if (right)
            hor += 1f;
        
        float ver = 0f;
        if (up)
            ver -= 1f;
        if (down)
            ver += 1f;


        var move = new Vector2f(hor, ver).toUnit().mul(deltaTime * 15);


        gameObject.position = Vector2f.add(gameObject.position, move);

    }
    
}
