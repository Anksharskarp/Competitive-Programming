package JavaClass9;

import java.awt.*;

import javax.swing.JFrame;

public class Homework9Part1 extends Canvas{
    /**
     *
     */
    private static final long serialVersionUID = -6616011577910876206L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Homework9Part1();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	  }
	public void paint(Graphics g) {
		
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));

        int s = 400;
        for (int k = 0; k < s; k += 10) {
          g2.drawLine(k, 0, s, k);
        }
        for (int k = 0; k < s; k += 10) {
          g2.drawLine(0, k, k, s);
        }
        for (int k = 0; k < s; k += 10) {
          g2.drawLine(0, 0, 0, 0);
        }
        for (int k = 0; k < s; k += 10) {
          g2.drawLine(0, 0, 0, 0);
        }
	  }
    
}