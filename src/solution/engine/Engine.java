package solution.engine;

import solution.engine.logic.SceneManager;
import solution.engine.input.Input;
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
    public final static int FPS = 5000;
    public final static int LUPS = 60;
    public final static int TPS = 60;
    private static String renderTime;
    ///////////////

    //

    //

    //

    //

    // Game stuff
    private Input input;
    private Window gameWindow;
    private SceneManager sceneManager;
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
    public static float SCALE = (float) WINDOW_HEIGHT / rendererY;
    ////////////////

    //

    //

    //

    // camera
    private Camera camera;
    //////

    //

    //

    //

    //

    //

    //

    private Renderer renderer;

    public Engine(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        running = false;
        gameThread = new Thread(this, GAME_NAME);

        gameWindow = new Window(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_NAME);

        renderer = new Renderer(rendererX, rendererY, gameWindow);

        input = new Input(gameWindow);

    }

    public void init() {
        gameWindow.init();
        sceneManager.init();
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
        final double timePerLightUpate = 1000000000 / LUPS;
        double deltaU = 0, deltaF = 0, deltaL = 0;
        int frames = 0, ticks = 0, lightUpdates = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timePerTick;
            deltaF += (currentTime - initialTime) / timePerFrame;
            deltaL += (currentTime - initialTime) / timePerLightUpate;
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
            if (deltaL >= 1) {
                updateLight();
                lightUpdates++;
                deltaL--;
            }

            if (System.currentTimeMillis() - timer > 1000) {

                renderTime = String.format("TPS: %s, FPS: %s, LUPS: %s", ticks, frames, lightUpdates);

                frames = 0;
                ticks = 0;
                lightUpdates = 0;
                timer += 1000;
            }
        }

    }

    public void input() {
        input.update(camera);
        // gameWindow.AppendTitle(Input.mouseX() + " : " + Input.mouseY());
    }

    public void update(float deltaTime) {
        sceneManager.update(deltaTime);
        gameWindow.AppendTitle(renderTime);
    }

    public void render() {
        BufferStrategy renderBuffer = gameWindow.getBufferStrategy();
        Graphics2D graphics = (Graphics2D) renderBuffer.getDrawGraphics();
        graphics.setColor(Color.WHITE);
        graphics.clearRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());

        camera = sceneManager.getCurrentScene().camera;
        renderer.setCamera(camera);
        renderer.render(graphics, gameWindow);

        renderBuffer.show();
        graphics.dispose();
    }

    public void updateLight() {
        renderer.renderLight();
    }

    public static String RENDER_TIME() {
        return renderTime;
    }

}