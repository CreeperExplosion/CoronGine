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
    static private String appendedTitle = " ";
    //

    //

    // Game loops //
    private final Thread gameThread;
    private boolean running;
    public final static int FPS = 5000;
    public final static int LUPS = 120;
    public final static int TPS = 60;
    private static String renderTime;
    ///////////////

    //

    //

    //

    //

    // Game stuff
    private final Input input;
    private final Window gameWindow;
    private final SceneManager sceneManager;
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
    private Renderer renderer;
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

    public Engine(final SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        running = false;
        gameThread = new Thread(this, GAME_NAME);

        gameWindow = new Window(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_NAME);

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
        } catch (final Exception e) {
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

            final long currentTime = System.nanoTime();
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
        this.camera = sceneManager.getCurrentScene().camera;
        input.update(camera);
    }

    public void update(final float deltaTime) {

        if (sceneManager.getCurrentScene().renderer == null)
            sceneManager.getCurrentScene().renderer = new Renderer(rendererX, rendererY, gameWindow);
        renderer = sceneManager.getCurrentScene().renderer;
        renderer.cleanup();

        sceneManager.update(deltaTime);
        gameWindow.AppendTitle(appendedTitle);

    }

    public void render() {

        if (renderer == null)
            return;

        final BufferStrategy renderBuffer = gameWindow.getBufferStrategy();
        final Graphics2D graphics = (Graphics2D) renderBuffer.getDrawGraphics();
        graphics.setColor(Color.WHITE);
        graphics.clearRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());
        renderer.setCamera(camera);
        renderer.render(graphics, gameWindow);

        renderBuffer.show();
        graphics.dispose();
    }

    public void updateLight() {
        if (renderer == null)
            return;

        renderer.renderLight();
    }

    public static String renderTime() {
        return renderTime;
    }

    public static void appendTitle(final String appendedTitle) {
        Engine.appendedTitle = appendedTitle;
    }

}