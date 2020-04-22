package solution.engine;

import solution.engine.logic.GameImplementation;
import solution.engine.input.Input;
import solution.engine.states.GameState;
import solution.engine.states.MenuState;
import solution.engine.states.State;
import solution.engine.graphics.Camera;
import solution.engine.graphics.Renderer;
import solution.engine.graphics.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable {
    //

    //

    //
    public final static String GAME_NAME = "CORONA GAME";
    //

    //

    // Game loops //
    private Thread gameThread;
    private boolean running;
    public final static int FPS = 50000;
    public final static int TPS = 60;
    private static String renderTime;
    ///////////////

    //

    //

    //

    //

    // Game stuff
    private Input input;
    Window gameWindow;
    GameImplementation gameImplementation;
    //////////////////

    //

    //

    //

    //

    // render and graphics stuff
    public static final int rendererY = 216;
    public static final int rendererX = rendererY * 16 / 9;
    public static final int WINDOW_HEIGHT = 720;
    public static final int WINDOW_WIDTH = WINDOW_HEIGHT * 16 / 9;
    public static float SCALE = (float) WINDOW_HEIGHT/rendererY;
    ////////////////

    //

    //

    //

    // camera
    Camera camera;
    //////
    
    //

    //

    //

    //

    //

    //
    private State gameState;
    private State menuState;

    private Renderer renderer;

    public Engine(GameImplementation gameImplementation) {
        this.gameImplementation = gameImplementation;
        running = false;
        gameThread = new Thread(this, GAME_NAME);

        gameWindow = new Window(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_NAME);

        renderer = new Renderer(rendererX, rendererY, gameWindow);

        // SET STATE TO GAME STATE
        gameState = new GameState(gameImplementation);
        menuState = new MenuState();
        State.setState(gameState);

        input = new Input(gameWindow);
    }

    public void init() {
        gameWindow.init();
        gameImplementation.init();
        gameState.init();
        menuState.init();

    };

    public void start() {
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
    public void run() {

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
                update((float) (deltaU * timePerTick) / 1000000000);
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

    public void input() {
        input.update(camera);
        gameWindow.AppendTitle(Input.mouseX() + ":" + Input.mouseY()+"+-"+ Engine.SCALE);
    }

    public void update(float deltaTime) {
        if (State.getState() != null) {
            State.getState().update(deltaTime);
        }
        // gameLogic.update(deltaTime);

      //  gameWindow.AppendTitle(renderTime);
    }

    public void render() {

        BufferStrategy renderBuffer = gameWindow.getBufferStrategy();
        Graphics2D graphics = (Graphics2D) renderBuffer.getDrawGraphics();
        graphics.setColor(Color.WHITE);
        graphics.clearRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());

        gameImplementation.render(renderer);

        camera = gameImplementation.getCamera();

        renderer.setCamera(camera);
        renderer.render(graphics, gameWindow);
        renderBuffer.show();
        graphics.dispose();

        
    }

    public static String RENDER_TIME() {
        return renderTime;
    }

}