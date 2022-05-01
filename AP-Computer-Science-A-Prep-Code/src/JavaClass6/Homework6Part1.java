package JavaClass6;

import java.awt.*;

import javax.swing.JFrame;

public class Homework6Part1 extends Canvas{
	
	/**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Homework6Part1();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	}

	public void paint(Graphics g) {
		Rectangle boundingBox = new Rectangle(200, 200, 400, 400);
		mickey(g, boundingBox);
	}
	
	public void mickey(Graphics g, Rectangle r) {
		int radius = r.width/2;
		if (radius <10)
            return;
        
        int rval, gval, bval;
	    rval = (int)Math.floor(Math.random() * 255);
	    gval = (int)Math.floor(Math.random() * 255);
	    bval = (int)Math.floor(Math.random() * 255);       
	    g.setColor(new Color(rval,gval,bval));
        g.fillRect(r.x, r.y, r.width, r.height);

		Rectangle left=new Rectangle(r.x-radius/2,  r.y-radius/2, radius, radius); 
		mickey(g, left);
		Rectangle right=new Rectangle(r.x+3*radius/2,  r.y-radius/2, radius, radius); 
		mickey(g, right);
		
	}
	
}