package JavaClass5;

import java.awt.*;
import javax.swing.JFrame; 

public class Homework5Solution extends Canvas{  
	
	/**
	 *
	 */
	private static final long serialVersionUID = -6771293199964973519L;

	public static void main(String[] args) {
			JFrame frame = new JFrame("My Graph");
			Canvas c = new Homework5Solution();
			c.setSize(400, 400);
			frame.add(c);
			frame.pack();
			frame.setVisible(true);
		}
		
	public void paint(Graphics g) {
		for(int i = 0;i<10;i++) {
			for(int j = 0;j<10;j++) 
				drawFace(g, i, j);
		}
	        
	}
	
	public void drawFace(Graphics g, int i, int j) {
		
		g.setColor(Color.yellow);
		g.fillOval(j*50, i*50, 50, 50);
		g.setColor(Color.black);
		g.fillRect(j*50+15, i*50+34, 20, 5);
		g.fillOval(j*50+11, i*50+15, 10, 10);
		g.fillOval(j*50+29, i*50+15, 10, 10);

	}
} 