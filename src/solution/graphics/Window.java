package solution.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

public class Window extends JFrame {

    private JPanel panel;
    private Canvas canvas;
    private int windowWidth = 720;
    private int windowHeight = 480;


    public Window(JPanel panel){
        this.panel = panel;
    }

    //SHOWS THE WINDOW FRAME
    public Window commit(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setPreferredSize(new Dimension(windowWidth,windowHeight));
        setSize(windowWidth,windowHeight);
        setContentPane(panel);
        setVisible(true);
        //frame.setLocationRelativeTo(null);
        //frame.pack();
        return this;
    }
    //SETS PARAMS
    public Window setWindowParams(int width, int height){
        this.windowWidth = width;
        this.windowHeight = height;
        return this;
    }

    public int[] getWindowParams(){
        return new int[]{this.windowWidth, this.windowHeight};
    }

    public Window setCanvas(Canvas canvas) {
        this.canvas = canvas;
        return this;
    }

    public JPanel getPanel() {
        return panel;
    }

    public Window addToPanel(Component c){
        this.panel.add(c);
        return this;
    }

    @Override
    public synchronized void addMouseListener(MouseListener mListener) {
        super.addMouseListener(mListener);
    }

    @Override
    public synchronized void addKeyListener(KeyListener keyListener) {
        super.addKeyListener(keyListener);
    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener motionListener) {
        super.addMouseMotionListener(motionListener);
    }
}
