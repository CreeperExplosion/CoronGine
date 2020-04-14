package solution.Game.game;


import solution.Game.game.logic.GameLogic;
import solution.Game.input.Input;
import solution.graphics.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameLoop implements Runnable{

    
    
    public final static String GAME_NAME = "CORONA GAME";
    
    private Thread gameThread;
    private boolean running;
    public final static int FPS = 120;
    public final static int TPS = 60;
    private static String renderTime;
    
    private Input input;

    Window gameWindow;

    GameLogic gameLogic;
    

    public GameLoop(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        running = false;
        gameThread = new Thread(this, GAME_NAME);

        gameWindow = new Window(GAME_NAME);

        input = new Input(gameWindow);
    }

    public void init(){
      gameWindow.init();
      gameLogic.init();
      
    };

    public void start(){
        running = true;
        init();
        gameWindow.show();
        try {
            gameThread.start();
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
        input.update();
    }

    public void update(){
        gameLogic.update();
    }
    public void render(){

        BufferStrategy renderBuffer = gameWindow.getBufferStrategy();
        Graphics2D graphics = (Graphics2D) renderBuffer.getDrawGraphics();
        graphics.setColor(Color.WHITE);

        graphics.clearRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());

        gameLogic.render(graphics);
        System.out.println(renderTime);


        // cleanup
        renderBuffer.show();
        graphics.dispose();
    }

    public static String RENDER_TIME(){
        return renderTime;
    }


}