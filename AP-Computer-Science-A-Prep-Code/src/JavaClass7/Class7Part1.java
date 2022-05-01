package JavaClass7;

import java.awt.*;

import javax.swing.JFrame;

public class Class7Part1 extends Canvas{
	
	/**
     *
     */
    private static final long serialVersionUID = 5419592611233872188L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Class7Part1();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void paint(Graphics g) {
		Rectangle r = new Rectangle(500, 0, 400, 100);
		mickey(g, r);
		}
		// Draws a tree diagram of black squares
		public void mickey(Graphics g, Rectangle bb) {
			if (bb.width > 10){
				g.fillRect(bb.x, bb.y, bb.width, bb.height);
				
				Rectangle left = new Rectangle(bb.x - bb.width / 2, bb.y + bb.height, bb.width / 2, bb.height);
				mickey(g, left);
				Rectangle right = new Rectangle(bb.x + bb.width, bb.y + bb.height, bb.width / 2, bb.height);
				mickey(g, right);
		}
	}
}
