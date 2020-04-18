package solution.engine.input;

import solution.engine.graphics.Window;

public class Input {

    private static KeyboardHandler keyboard;

    private static MouseHandler mouse;

    public Input(Window window) {

        keyboard = new KeyboardHandler(1024);
        mouse = new MouseHandler(64);

        window.addKeyListener(keyboard);
        window.addMouseListener(mouse);
        window.addMouseMotionListener(mouse);
    }

    public void update(){
        keyboard.update();
        mouse.update();
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
    public static int mouseX(){
        return mouse.mouseX;
    }

    public static int mouseY(){
        return mouse.mouseY;
    }


}