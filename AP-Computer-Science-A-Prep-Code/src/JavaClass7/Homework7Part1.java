package JavaClass7;

import java.awt.*;

import javax.swing.JFrame;

public class Homework7Part1 extends Canvas { 
    /**
     *
     */
    private static final long serialVersionUID = 8912711105235113507L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Homework7Part1();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void paint(Graphics g) {
		Rectangle r = new Rectangle(500, 0, 400, 100);
		circle(g, r);
	}
		// Draws a tree diagram of black squares
		public void circle(Graphics g, Rectangle bb) {
            int times = 0;
			if (times < 2) {
                for (int i = 1; i <= 2; i++) {
                    
                }
            }
		}       
}