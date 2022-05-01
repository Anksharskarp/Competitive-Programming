package JavaClass7;

import java.awt.*;

import javax.swing.JFrame;

public class Class7Part2 extends Canvas{
	
	/**
     *
     */
    private static final long serialVersionUID = 5419592611233872188L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Class7Part2();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void paint(Graphics g) {
		Rectangle r = new Rectangle(500, 0, 40, 40);
		drawNode(g, r, 1);
		}
        // Draws a colorful tree diagram of randomly colored squares
		public void drawNode(Graphics g, Rectangle bb, int level) {
		
			Graphics2D g2 = (Graphics2D) g;

			int rVal = (int) (Math.random()*225);
			int gVal = (int) (Math.random()*225);
			int bVal = (int) (Math.random()*225);
			g2.setColor(new Color(rVal, gVal, bVal));

			if (level < 15){
				g.fillRect(bb.x, bb.y, bb.width, bb.height);
				Rectangle left = new Rectangle(bb.x - bb.width, bb.y + bb.height, bb.width, bb.height);
				drawNode(g, left, level + 1);
				Rectangle right = new Rectangle(bb.x + bb.width, bb.y + bb.height, bb.width, bb.height);
				drawNode(g, right, level + 1);
		}
	}
}