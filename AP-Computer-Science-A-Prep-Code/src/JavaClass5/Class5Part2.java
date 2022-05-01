package JavaClass5;

import java.awt.*;
import javax.swing.JFrame;

public class Class5Part2 extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 4353623690387124540L;

   public static void main(String[] args) {
        JFrame frame = new JFrame("My Graph");
        Canvas c = new Class5Part2(); 
        c.setSize(400, 400); 
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(100, 100, 200, 200);
        g.setColor(Color.yellow);
        g.fillOval(150, 150, 40, 40);
        g.fillOval(200, 150, 40, 40);
        g.setColor(Color.red);
        g.fillOval(160, 200, 80, 80);
        g.setColor(Color.black);
        g.fillOval(160, 185, 80, 80);
        g.drawString("This is my painting.", 100, 50);
    }
}

