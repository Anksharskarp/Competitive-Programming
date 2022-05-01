package JavaClass6;

import java.awt.*;

import javax.swing.JFrame;

public class Class6Part1 extends Canvas {
	
	/**
     *
     */
    private static final long serialVersionUID = -4342050772077653083L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Class6Part1();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
        frame.setVisible(true);
	}
	
	
	public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); // Changes brush/pen size
        //g2.setColor(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight()); // Gets the dimensions of the drawing canvas

	    int rval, gval, bval;
	        for (int i = 1; i <=20; i++) {
	               rval = (int)Math.floor(Math.random() * 255);
	               gval = (int)Math.floor(Math.random() * 255);
	               bval = (int)Math.floor(Math.random() * 255);       
	               g2.setColor(new Color(rval,gval,bval));
	               g2.drawOval(i*17, i*17, 400-20*i, 400-20*i);
	          }
	    }
}
