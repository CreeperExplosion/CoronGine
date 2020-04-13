package solution.Game.input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener{

    InputKey[] keys;
    boolean[] keyHelper;

    public KeyboardHandler(int numberOfKeys) {

        keys = new InputKey[numberOfKeys];
        keyHelper = new boolean[numberOfKeys];

        for (int i = 0; i < numberOfKeys; i++) {
            keys[i] = new InputKey();
        }
        
    }

    public void update(){

        for (int i = 0; i < keyHelper.length; i++) {
                if(keyHelper[i]){
                    keys[i].press();
                }
                else{
                    keys[i].release();
                }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyHelper[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyHelper[e.getKeyCode()] = false;
    }

}