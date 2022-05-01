package JavaClass5;

import java.awt.*;
import javax.swing.JFrame;

public class Class5Part4 extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 6913952725723998631L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colorful Mosaic");
        Canvas c = new Class5Part4(); 
        c.setSize(400, 400); 
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        //Draws numerous concentric circles
        for (int i = 0; i <= 20; i++) {
            int rval = (int) (Math.random()*255);
            int gval = (int) (Math.random()*255);
            int bval = (int) (Math.random()*255);
            g.setColor(new Color(rval, gval, bval));
            g.fillOval(i * 10, i * 10, 400 - 20 * i, 400 - 20 * i);
        }

        
    }
}