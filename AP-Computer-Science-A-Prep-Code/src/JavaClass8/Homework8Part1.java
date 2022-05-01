package JavaClass8;

import java.awt.*;

import javax.swing.JFrame;

public class Homework8Part1 extends Canvas{
    /**
     *
     */
    private static final long serialVersionUID = -6616011577910876206L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Homework8Part1();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	  }
	public void paint(Graphics g) {
		
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        for (int i = 0; i < 100; i++) {
            int rVal = (int) (Math.random()*255);
            int gVal = (int) (Math.random()*255);
            int bVal = (int) (Math.random()*255);
            g2.setColor(new Color(rVal, gVal, bVal));

            int[] xpoints = {(int) (Math.random()*1000), (int) (Math.random()*1000), (int) (Math.random()*1000)};
            int[] ypoints = {(int) (Math.random()*1000), (int) (Math.random()*1000), (int) (Math.random()*1000)};
            int npoints = 3;
            g.fillPolygon(xpoints, ypoints, npoints);
	  }
    
  }
}