package solution.engine.input;


import java.awt.event.*;


/**
 * MouseHandler
 *
 */
public class MouseHandler implements MouseMotionListener, MouseListener {


    InputKey[] keys;
    
    boolean[] keyHelper;

    boolean mouseInside;

    int mouseX, mouseY;

    public MouseHandler(int numberOfKeys) {
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
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        keyHelper[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        keyHelper[e.getButton()] = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseInside = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseInside = false;

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    
}