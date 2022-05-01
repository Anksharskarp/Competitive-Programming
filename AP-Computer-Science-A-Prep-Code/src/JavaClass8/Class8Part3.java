package JavaClass8;

import java.awt.*;

import javax.swing.JFrame;

public class Class8Part3 extends Canvas{
	
	/**
     *
     */
    private static final long serialVersionUID = 5419592611233872188L;

    public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Canvas c = new Class8Part3();
		c.setSize(400, 400);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void paint(Graphics g) {
		
        Graphics2D g2 = (Graphics2D) g;
        int length = 10;
        int x1 = 300;
        int y1 = 300;
        g2.setStroke(new BasicStroke(3));

        for (int i = 0; i < 100; i++) {
            int rVal = (int) (Math.random()*255);
            int gVal = (int) (Math.random()*255);
            int bVal = (int) (Math.random()*255);
            g2.setColor(new Color(rVal, gVal, bVal));

            g2.drawLine(x1, y1, x1 + length, y1);
            g2.drawLine(x1 + length, y1, x1 + length, y1 - length);
            g2.drawLine(x1 + length, y1 - length, x1 - 5, y1 - length);
            g2.drawLine(x1 - 5, y1 - length, x1 - 5, y1 + 5);
            x1 = x1 - 5;
            y1 = y1 + 5;
            length = length + 10; 
        }
	}
    
}
