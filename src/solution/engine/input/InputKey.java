package solution.engine.input;

import solution.engine.Util.Timer;

public class InputKey {

    private static long reactionTimeinMillis = 100;

    private boolean pressed = false;

    private boolean previouslyPressed = false;

    Timer pressTimer;
    Timer releaseTimer;


    InputKey() {
        pressTimer = new Timer();
        releaseTimer = new Timer();
    }

    void press() {
        pressTimer.start();
        releaseTimer.stop();
        if(pressTimer.getTime()<0)
            return;
       
        // baru aja di pencet
        
        if (pressTimer.getTime() < reactionTimeinMillis){
            pressed = true;
            previouslyPressed = false;
        }
        if (pressTimer.getTime() > reactionTimeinMillis){
            pressed = true;
            previouslyPressed = true;
        }

        
    }

    void release() {
        releaseTimer.start();
        pressTimer.stop();

        if(releaseTimer.getTime() < 0)
            return;

        if (releaseTimer.getTime() < reactionTimeinMillis){
            
            pressed = false;
            previouslyPressed = true;
        }
        if (releaseTimer.getTime() > reactionTimeinMillis){
            pressed = false;
            previouslyPressed = false;
        }
    }


    /**
     * @return the pressed
     */
    boolean isPressed() {
        return pressed && !previouslyPressed;
    }
    /**
     * @return the released
     */
    boolean isReleased() {
        return !pressed && previouslyPressed;
    }

    boolean isHeld(){
        return pressed && previouslyPressed;
    }



    public static long getReactionTimeinMillis() {
        return reactionTimeinMillis;
    }


    public static void setReactionTimeinMillis(long reactionTimeinMillis) {
        InputKey.reactionTimeinMillis = reactionTimeinMillis;
    }


    
}