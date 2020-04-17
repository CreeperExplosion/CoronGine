package solution.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Window {

    private int width;
    private int height;

    private Canvas canvas;

    String title;

    JFrame gameFrame;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        
        gameFrame = new JFrame(title);
        canvas = new Canvas();
    }

    public Window(String title) {
        this(720, 480, title);
    }

    public void init() {
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setTitle(title);
        gameFrame.pack();
        gameFrame.setResizable(true);
        gameFrame.add(canvas);


        gameFrame.add(canvas);
        

        canvas.setSize(width, height);

        gameFrame.pack();

        gameFrame.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {

                int newHeight = e.getComponent().getHeight();
                int newWidth = e.getComponent().getWidth();
                if(height != newHeight){

                    height = newHeight;
                    width = height *16/9;
                }

                if(width != newWidth){

                    width = newWidth;
                    height = width *9/16;
                }

                setWindowSize(width, height);

            }
            public void componentMoved(ComponentEvent e) {
            }
            public void componentShown(ComponentEvent e) {
            }
            public void componentHidden(ComponentEvent e) {
            } 
        });


       canvas.setBackground(new Color(255,255,255,255));
    }

    public void show(){
        gameFrame.setVisible(true);
        canvas.setVisible(true);
        gameFrame.requestFocus();
        canvas.requestFocus();
        gameFrame.setLocationRelativeTo(null);
    }

    //SETS PARAMS
    public void setWindowSize(int width, int height){
        this.width = width;
        this.height = height;
        gameFrame.setSize(width,height);
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
