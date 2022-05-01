package JavaClass9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Creates a bouncing ball animation
public class Class9Part2 extends JPanel implements ActionListener {
    // JPanel has more features and components. Better for more complex UI

    /**
     *
     */
    private static final long serialVersionUID = 3164830092077645749L;

    Timer t = new Timer(100, this); // 'this' implies that we are adding a timer for this object
    int x = 200, y = 200;
    int xVel = 20, yVel = 30;
    Color currentColor = new Color(0, 0, 0);

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Graph");
        Class9Part2 c = new Class9Part2();
        c.setSize(400, 400);
        frame.add(c);
        // frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        g.fillOval(x, y, 100, 100);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Updates the location every 3 seconds. If there is a header, leave it
                                                 // alone, or delete
        x += xVel;
        y += yVel;

        if ((x > 500) || (x < 0))
            xVel = -xVel;
        if ((y > 500) || (y < 0))
            yVel = -yVel;

        currentColor = new Color(((int) (Math.random() * 255)), ((int) (Math.random() * 255)),
                ((int) (Math.random() * 255)));
        repaint();
    }
}