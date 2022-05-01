package JavaClass11;

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
*/
/*
Your homework assignment is to add a dynamic score button in the game.
The larger the ball is, the smaller your score. The smaller the ball,
the larger your score. Make the score button change.
*/
public class Class11Part6 extends JPanel implements ActionListener, MouseListener, KeyListener{
	
	/**
     *
     */
    private static final long serialVersionUID = 1880568328048993336L;
    Timer t = new Timer(200, this);
	int[] x= new int[100];
	int[] y= new int[100];
	int[] radius = new int[100];
	int[] xVel= new int[100];
	int[] yVel= new int[100];
	Color[] colors = new Color[100];
    boolean[] show = new boolean[100];
    int score = 0;
	
	public Class11Part6() {
		for (int i =0; i<100; i++) {
			x[i] = (int) (Math.random()*500);
			y[i] = (int) (Math.random()*500);
			radius[i] = (int) (Math.random()*100);
			xVel[i] = (int) (Math.random()*50);
			yVel[i] = (int) (Math.random()*50);
			colors[i] = new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
			show[i] = true;
		}
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        
	}
	
	public static void main(String[] args)
    {
		JFrame frame = new JFrame("My Graph");
		Class11Part6 c = new Class11Part6();
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
		for (int i = 0; i<100; i++) {
			if (show[i]) {
			g.setColor(colors[i]);
			g.fillOval(x[i], y[i], radius[i], radius[i]);
			}
		}
        g.drawString("Score", 600, 100);
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
		
		for ( int i = 0; i<100; i++) {
			if  ((Math.abs(e.getX() - x[i])< radius[i])  &&  (Math.abs(e.getY() - y[i])< radius[i])){
					show[i] = false;
			}
			
		}
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
                yVel[i] = -10;
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            for (int i = 0; i < 100; i++) {
                yVel[i] = 10;
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            for (int i = 0; i < 100; i++) {
                xVel[i] = -10;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            for (int i = 0; i < 100; i++) {
                xVel[i] = 10;
            }
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
       

    }
}



