package JavaClass30;

/*
A Java program that draws a a repeating pattern of circles, with a shrinking
radius from left to right. The starting radius, and the termination radius
can both be adjusted by changing the parameters of the 'drawBalls' method.
*/

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.event.*;

public class Class30Part2 extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -8686817773355634815L;
    Timer t = new Timer(100, this);
    int x = 0;
    int velX = 20;
    int y = 0;
    int velY = 30;

    int red = 0;
    int blue = 0;
    Color currentColor = new Color(red, 0, 0);
    int score = 0;

    public static void main(String[] args) {

        Class30Part2 c = new Class30Part2();
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(1000, 300);
        j.add(c);
        j.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);

        drawBalls(g, 0, 0, 100);
    }

    public void drawBalls(Graphics g, int x, int y, int radius) {
        //Don't forget the termination conditions, or you'll end up with an infinite loop,
        //a common mistake made when implementing recursive functions.
        if (radius >= 5) {
            g.fillOval(x, y, radius * 2, radius * 2);
            drawBalls(g, x + 2 * radius, y, (int) (radius * 0.8));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Left blank, because it is not needed here.
    }
}