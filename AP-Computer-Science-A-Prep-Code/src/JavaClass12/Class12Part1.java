package JavaClass12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
This is a simple game written in Java
It displays numerous bouncing balls,
and you need to click on them to make
the balls disappear. If you press the keyboard
arrow keys, then the balls all go in one direction.
If the ball movement is too shaky for your to handle,
you can adjust the Timer to change the fps.
*/
public class Class12Part1 extends JPanel implements ActionListener, MouseListener, KeyListener{
    /**
     *
     */
    private static final long serialVersionUID = 4700172795615103154L;
    Timer t = new Timer(200, this);
	int[] x= new int[100];
	int[] y= new int[100];
	int[] radius = new int[100];
	int[] xVel= new int[100];
	int[] yVel= new int[100];
	Color[] colors = new Color[100];
    boolean[] show = new boolean[100];
    int score = 0;
    int count = 0;
	
	public Class12Part1() {
        /*
		for (int i =0; i<100; i++) {
			x[i] = (int) (Math.random()*500);
			y[i] = (int) (Math.random()*500);
			radius[i] = (int) (Math.random()*100);
			xVel[i] = (int) (Math.random()*50);
			yVel[i] = (int) (Math.random()*50);
			colors[i] = new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
			show[i] = true;
        }
        */
        addMouseListener(this);
        /*
        addKeyListener(this);
        setFocusable(true);
        */
        
	}
	
	public static void main(String[] args)
    {
		JFrame frame = new JFrame("My Graph");
		Class12Part1 c = new Class12Part1();
		//c.setSize(400, 400);
		frame.setPreferredSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		  
    }
	
	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		for (int i = 0; i<count; i++) {
			if (show[i]) {
			g.setColor(colors[i]);
			g.fillOval(x[i], y[i], radius[i], radius[i]);
			}
        }
        g.drawString("Score: " + score, 600, 100);
        g.drawString("------------------------", 600, 140);
        g.drawString("Score chart:", 600, 150);
        g.drawString("Large Balls: +25", 600, 170);
        g.drawString("Medium Balls: +50", 600, 190);
        g.drawString("Small Balls: +100", 600, 210);
        g.drawString("Score chart: +200", 600, 230);
        g.drawString("------------------------", 600, 250);
		t.start();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for ( int i = 0; i<100; i++) {
			x[i] += xVel[i];
			y[i] += yVel[i];
			
			if ((x[i]> 500) || (x[i]<0))
				xVel[i] = -xVel[i];
			if ((y[i]> 500) || (y[i]<0))
				yVel[i] = -yVel[i];	
			
		}
		
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		for ( int i = 0; i<100; i++) {
			if  ((Math.abs(e.getX() - x[i])< radius[i])  &&  (Math.abs(e.getY() - y[i])< radius[i])){
                    show[i] = false;
                    if (radius[i] >= 0 && radius[i] <= 25) {
                        score += 200;
                    } else if (radius[i] > 25 && radius[i] <= 50){
                        score += 100;
                    } else if (radius[i] > 50 && radius[i] <= 75) {
                        score += 50;
                    } else {
                        score += 25;
                    }
                    
			}
			
        }
        */

        x[count] = e.getX();
        y[count] = e.getY();
        radius[count] = (int) (Math.random() * 100);
        xVel[count] = (int) (Math.random() * 50);
        yVel[count] = (int) (Math.random() * 50);
        colors[count] = new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
        show[count] = true;
        count++;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

    @Override
    public void keyTyped(KeyEvent e) {
     

    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            for (int i = 0; i < 100; i++) {
                xVel[i] = 0;
                yVel[i] = -10;
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            for (int i = 0; i < 100; i++) {
                xVel[i] = 0;
                yVel[i] = 10;
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            for (int i = 0; i < 100; i++) {
                xVel[i] = -10;
                yVel[i] = 0;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            for (int i = 0; i < 100; i++) {
                xVel[i] = 10;
                yVel[i] = 0;
            }
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        

    }
}