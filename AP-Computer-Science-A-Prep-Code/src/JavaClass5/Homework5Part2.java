package JavaClass5;

import java.awt.*;
import javax.swing.JFrame;

public class Homework5Part2 extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 10266774581765009L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Graph");
        Canvas c = new Homework5Part2(); 
        c.setSize(400, 400); 
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(100, 100, 200, 200);
        g.setColor(Color.blue);
        g.fillOval(150, 150, 30, 30);
        g.fillOval(220, 150, 30, 30);
        g.setColor(Color.red);
        g.fillRect(180, 240, 50, 10);
        
    }
}