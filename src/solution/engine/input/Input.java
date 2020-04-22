package solution.engine.input;

import solution.engine.Engine;
import solution.engine.graphics.Camera;
import solution.engine.graphics.Window;

public class Input {

    private static KeyboardHandler keyboard;

    private static MouseHandler mouse;


    private static float mouseCameraX = 0;
    private static float mouseCameraY = 0;

    public Input(Window window) {

        keyboard = new KeyboardHandler(1024);
        mouse = new MouseHandler(64);

        window.addKeyListener(keyboard);
        window.addMouseListener(mouse);
        window.addMouseMotionListener(mouse);
    }

    public void update(Camera camera){
        keyboard.update();
        mouse.update();

        mouseCameraX  = ( + mouse.mouseX)/ Engine.SCALE;
        mouseCameraY  = (+ mouse.mouseY)/ Engine.SCALE;

        mouseCameraX -= (float)Engine.rendererX / 2;
        mouseCameraY -= (float)Engine.rendererY / 2;

        mouseCameraX -= camera.getX();
        mouseCameraY -= camera.getY();
    }


    public static boolean getKeyDown(int keyCode){
       return keyboard.keys[keyCode].isPressed();
    }
    public static boolean getKeyHeld(int keyCode){
        return keyboard.keys[keyCode].isHeld();

    }
    public static boolean getKeyRelease(int keyCode){
        return keyboard.keys[keyCode].isReleased();
    }

    public static boolean getMouseKeyDown(int keyCode){
        return mouse.keys[keyCode].isPressed();
    }
    public static boolean getMouseKeyRelease(int keyCode){
        return mouse.keys[keyCode].isReleased();
    }
    public static boolean getMouseKeyHeld(int keyCode){
        return mouse.keys[keyCode].isHeld();
    }
    public static boolean mouseInside(){
        return mouse.mouseInside;
    }
    public static float mouseX(){
        return mouseCameraX;
    }

    public static float mouseY(){
        return  mouseCameraY;
    }


}