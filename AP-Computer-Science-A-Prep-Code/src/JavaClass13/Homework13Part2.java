package JavaClass13;

import java.awt.*;
import javax.swing.*;

public class Homework13Part2 extends JPanel {
	/**
     *
     */
    private static final long serialVersionUID = -2988948060419076280L;
    static Color wheel = new Color(80, 80, 80);
	static Color body =  new Color(255, 160, 0);
	static Color window= new Color (0, 160, 255);
	int cars = (int) (Math.random()*5)+2;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My Graph");
		Homework13Part2 c = new Homework13Part2();
		frame.setPreferredSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
	}
	public static void drawCar(int x, int y, int size, Graphics g) {
		//g.fillOval(x+(size/2), y+(size), 5, 5);
		g.setColor(body);
		g.fillRect(x, y, size, size / 2);
		g.setColor(wheel);
		g.fillOval(x + (size / 6), y + (size / 3), size / 5, size / 5);
		g.fillOval(x + size - (size / 3), y + (size / 3), size / 5, size / 5);
		g.setColor(window);
		g.fillRect(x + ((size * 2) / 3) + 1, y + (size / 12), size / 3, size / 6) ;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int i = 0; i < cars; i++) {
			drawCar((int) (Math.random() * 500) + 100, (int) (Math.random() * 500 + 100), (int) (Math.random() * 300), g);
		}
	}
}
