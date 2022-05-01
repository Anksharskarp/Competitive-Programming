package JavaClass5;

import java.awt.*;
import javax.swing.JFrame;

public class Class5Part3 extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 6913952725723998631L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colorful Mosaic");
        Canvas c = new Class5Part3(); 
        c.setSize(400, 400); 
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        
        for (int i = 0; i <= 20; i++)
            for (int j = 0; j <= 20; j++) {
            int rval = (int) (Math.random()*255); // Make sure to include parenthesis in front of the methods!
            int gval = (int) (Math.random()*255);
            int bval = (int) (Math.random()*255);
            g.setColor(new Color(rval, gval, bval));
            g.fillRect(i * 30, j * 30, 25, 25);
            }

        
    }
}