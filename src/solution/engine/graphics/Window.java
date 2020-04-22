package solution.engine.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Window {

    private int width;
    private int height;

    private Canvas canvas;

    String title;

    JFrame frame;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        
        frame = new JFrame(title);
        canvas = new Canvas();
    }

    public Window(String title) {
        this(720, 480, title);
    }

    public void init() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setResizable(false);
        frame.add(canvas);


        frame.add(canvas);
        

        canvas.setSize(width, height);

        frame.pack();


       canvas.setBackground(new Color(255,255,255,255));
    }

    public void show(){
        frame.setVisible(true);
        canvas.setVisible(true);
        frame.requestFocus();
        canvas.requestFocus();
        frame.setLocationRelativeTo(null);
    }

    //SETS PARAMS
    public void setWindowSize(int width, int height){
        this.width = width;
        this.height = height;
        frame.setSize(width,height);
        canvas.setSize(new Dimension(width,height));
    }

    public BufferStrategy getBufferStrategy(){
        if(canvas.getBufferStrategy() == null)
            canvas.createBufferStrategy(4);
        return canvas.getBufferStrategy();
    }

    public Graphics2D getGraphics(){
        return (Graphics2D) canvas.getGraphics();
    }


    public void AppendTitle(String app) {
        frame.setTitle(title+ "   " +app);
    }
    
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    public void addMouseListener(MouseListener mListener) {
        canvas.addMouseListener(mListener);
    }

    public void addKeyListener(KeyListener keyListener) {
        canvas.addKeyListener(keyListener);
    }

    public void addMouseMotionListener(MouseMotionListener motionListener) {
        canvas.addMouseMotionListener(motionListener);
    }
}
