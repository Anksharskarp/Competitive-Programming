package JavaClass12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Homework12Part1 extends JPanel implements ActionListener, MouseListener{

    /**
     *
     */
    private static final long serialVersionUID = -5289575307261461583L;
    Timer t = new Timer(200, this);
    int[] x= new int[100];
    int[] y= new int[100];
    int[] radius = new int[100];
    Color[] colors = new Color[100];
    int count = 0;

    public Homework12Part1() {
        addMouseListener(this);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("My Graph");
        Homework12Part1 c = new Homework12Part1();
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
            for ( int j = 0; j < 20; j++) {
                g.drawOval(x[i] - 10 * j / 2, y[i] - 10 * j / 2, 10 * j, 10 * j);
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        x[count] = e.getX();
        y[count] = e.getY();
        radius[count] = (int) (Math.random() * 100);
        colors[count] = new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255));	
        count++;
        repaint();
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
    public void actionPerformed(ActionEvent e) {

        
    }

}

