package JavaClass12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Class12Part2 extends JPanel implements ActionListener, MouseListener, KeyListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(200, this);
    int[] x= new int[100];
    int[] y= new int[100];
    int[] radius = new int[100];
    Color[] colors = new Color[100];
    int score = 0;
    int count = 0; 

    public Class12Part2() {
        /*
        for (int i =0; i<100; i++) {
        x[i] = (int) (Math.random()*500);
        y[i] = (int) (Math.random()*500);
        radius[i] = (int) (Math.random()*100);
        xVel[i] = (int) (Math.random()*50);
        yVel[i] = (int) (Math.random()*50);
        colors[i] = new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
        show[i] = true;
    }
        */
        
    addMouseListener(this);
    //addKeyListener(this);
    //setFocusable(true); //needed for the keyListener to work
    //KeyListeners need to be on the focused component to work. One solution is to give your component the focus after first making it focusable.
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Graph");
        Class12Part2 c = new Class12Part2();
        //c.setSize(400, 400);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < count; i++) {
            g.setColor(colors[i]);
            //g.fillOval(x[i], y[i], radius[i], radius[i]);
            for (int j = 0; j < 20; j++) {
                g.drawOval(x[i], y[i], 10 * j, 10 * j);
            }
        }
    }
    /*
    g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
    g.drawString("Score: " + Integer.toString(score), 600, 50);

    t.start();
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x[count] = e.getX();
        y[count] = e.getY();
        radius[count] = (int) (Math.random() * 100);
        colors[count] = new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255));
        count++;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    System.out.println("key pressed");
    int c = e.getKeyCode();
    System.out.println("key code: "+ c);
    System.out.println(KeyEvent.VK_LEFT + " "+KeyEvent.VK_RIGHT);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}