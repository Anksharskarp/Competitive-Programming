package JavaClass10;

import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Creates a bouncing ball animation
// WITH 100 BOUNCING BALLS WITH 100 RANDOM COLORS!
// If you click on the balls, they disappear!
public class Homework10Part1 extends JPanel implements ActionListener, MouseListener {
    // JPanel has more features and components. Better for more complex UI

    /**
     *
     */
    private static final long serialVersionUID = -2594453879736483794L;
    // Change the timer to 50 for super fast graphics
    // Change the timer to 200 for slow/laggy graphics
    Timer t = new Timer(100, this); // 'this' implies that we are adding a timer for this object
    int[] x = new int[100];
    int[] y = new int[100]; // Alternatively, we could create class Ball
    int[] radius = new int[100];
    int[] xVel = new int[100];
    int[] yVel = new int[100];
    Color[] colors = new Color[100];
    boolean[] show = new boolean[100];
    // Create constructor function with the same name as the enclosing class

    public Homework10Part1() {
        for (int i = 0; i < 100; i++) {
            x[i] = (int) (Math.random() * 500);
            y[i] = (int) (Math.random() * 500);
            radius[i] = (int) (Math.random() * 100);
            xVel[i] = (int) (Math.random() * 50);
            yVel[i] = (int) (Math.random() * 50);
            colors[i] = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            show[i] = true;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Graph");
        Homework10Part1 c = new Homework10Part1();
        // c.setSize(400, 400);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 100; i++) {
            if (show[i]) {
                g.setColor(colors[i]);
                g.fillOval(x[i], y[i], radius[i], radius[i]);
            }
        }
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Updates the location every 3 seconds. If there is a header, leave it
                                                 // alone, or delete

        for (int i = 0; i < 100; i++) {
            x[i] += xVel[i];
            y[i] += yVel[i];

            // Prevents the ball from bouncing out of the screen
            if ((x[i] > 500) || (x[i] < 0))
                xVel[i] = -xVel[i];
            if ((y[i] > 500) || (y[i] < 0))
                yVel[i] = -yVel[i];
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < 100; i++) {
            if ((Math.abs(e.getX() - x[i]) < radius[i]) && (Math.abs(e.getY() - y[i]) < radius[i])) {
                show[i] = false;
            }
        }
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
}