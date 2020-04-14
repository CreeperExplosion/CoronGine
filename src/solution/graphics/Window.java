package solution.graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.awt.Component.CENTER_ALIGNMENT;

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
        gameFrame.setSize(width, height);
        gameFrame.setPreferredSize(new Dimension(width,height));
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setTitle(title);
        gameFrame.pack();
        gameFrame.setResizable(false);
        gameFrame.add(canvas);


        gameFrame.add(canvas);
        


        canvas.setSize(width, height);

        gameFrame.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                width = e.getComponent().getWidth();
                height = e.getComponent().getWidth();
                canvas.setSize(new Dimension(e.getComponent().getSize()));
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



    public int getWidth(){
        return height;
    }
    public int getHeight(){
        return width;
    }

    public void addMouseListener(MouseListener mListener) {
        gameFrame.addMouseListener(mListener);
    }

    public void addKeyListener(KeyListener keyListener) {
        gameFrame.addKeyListener(keyListener);
    }

    public void addMouseMotionListener(MouseMotionListener motionListener) {
        gameFrame.addMouseMotionListener(motionListener);
    }
}
