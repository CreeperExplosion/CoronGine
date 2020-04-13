package solution.Game.input;

public class InputKey {

    private static long reactionTimeinMillis = 100;

    private boolean pressed;

    private boolean previouslyPressed;

    private static long beforeTime;

    private static long currentTime;


    public InputKey() {
        beforeTime = System.currentTimeMillis();
    }

    public void press() {
        currentTime = System.currentTimeMillis();

        //perbedaan waktu antara current dan before
        long deltaTime = currentTime - beforeTime;

        // baru aja di pencet
        if (deltaTime > reactionTimeinMillis){
            this.pressed = true;
            previouslyPressed = false;
        }
        if (deltaTime <= reactionTimeinMillis){
            this.pressed = true;
            this.previouslyPressed = true;
        }

        beforeTime = currentTime;
    }

    public void release() {
        currentTime = System.currentTimeMillis();

        //perbedaan waktu antara current dan before
        long deltaTime = currentTime - beforeTime;

        if (deltaTime > reactionTimeinMillis){
            this.pressed = false;
            previouslyPressed = false;
        }
        if (deltaTime <= reactionTimeinMillis){
            this.pressed = false;
            this.previouslyPressed = true;
        }
    }


    /**
     * @return the pressed
     */
    public boolean isPressed() {
        return pressed &&  !previouslyPressed;
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