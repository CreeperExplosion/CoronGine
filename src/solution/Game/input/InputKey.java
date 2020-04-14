package solution.Game.input;

import solution.Game.Util.Timer;

public class InputKey {

    private static long reactionTimeinMillis = 100;

    private boolean pressed = false;

    private boolean previouslyPressed = false;

    Timer pressTimer;
    Timer releaseTimer;


    public InputKey() {
        pressTimer = new Timer();
        releaseTimer = new Timer();
    }

    public void press() {
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

    public void release() {
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
    public boolean isPressed() {
        return pressed && !previouslyPressed;
    }
    /**
     * @return the released
     */
    public boolean isReleased() {
        return !pressed && previouslyPressed;
    }

    public boolean isHeld(){
        return pressed && previouslyPressed;
    }



    public static long getReactionTimeinMillis() {
        return reactionTimeinMillis;
    }


    public static void setReactionTimeinMillis(long reactionTimeinMillis) {
        InputKey.reactionTimeinMillis = reactionTimeinMillis;
    }


    
}