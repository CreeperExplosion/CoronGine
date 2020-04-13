package solution.Game;


import solution.Game.input.KeyboardHandler;
import solution.Game.input.MouseHandler;

public class CoronaGame implements Runnable{

    private Thread gameThread;

    private boolean running;

    public final static String GAME_NAME = "CORONA GAME";

    public final static int FPS = 120;

    public final static int TPS = 30;

    private static String renderTime;

    private KeyboardHandler keyboardHandler;

    private MouseHandler mouseHandler;
    

    public CoronaGame() {
        running = false;
        gameThread = new Thread(this, GAME_NAME);

        keyboardHandler = new KeyboardHandler(1024);

        mouseHandler = new MouseHandler();
    }

    public void start(){
        running = true;
        
        
        try {
            this.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){


        long initialTime = System.nanoTime();
        final double timePerTick = 1000000000 / TPS;
        final double timePerFrame = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();
        
            while (running) {
        
                long currentTime = System.nanoTime();
                deltaU += (currentTime - initialTime) / timePerTick;
                deltaF += (currentTime - initialTime) / timePerFrame;
                initialTime = currentTime;
        
                if (deltaU >= 1) {
                    input();
                    update();
                    ticks++;
                    deltaU--;
                }
        
                if (deltaF >= 1) {
                    render();
                    frames++;
                    deltaF--;
                }
        
                if (System.currentTimeMillis() - timer > 1000) {
                    
                        renderTime = String.format("TPS: %s, FPS: %s", ticks, frames);
                    
                    frames = 0;
                    ticks = 0;
                    timer += 1000;
                }
            }

    }

    public void input(){
        keyboardHandler.update();
    }

    public void update(){

    }
    public void render(){

    }

    public static String RENDER_TIME(){
        return renderTime;
    }


}