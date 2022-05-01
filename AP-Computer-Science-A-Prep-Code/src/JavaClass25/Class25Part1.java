package JavaClass25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Class25Part1 {
    private final JFrame frame;

    public Class25Part1() {
        frame = new JFrame("DrawGrid");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new cPanel(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Class25Part1();
    }

    public static class cPanel extends JPanel  implements MouseListener {
        /**
         *
         */
        private static final long serialVersionUID = -8631708510421141310L;
        int cellSize = 70;
        int turn = 0;
        int rows = 7;
        int cols = 7;
        boolean winner=false;
        String ccolor = "";
        Color[][] grid = new Color[rows][cols];
        
        public cPanel(Dimension dimension) {
            setSize(dimension);
            addMouseListener(this);
            //1. initialize grid here
            for (int i = 0 ; i<rows; i++)
                for (int j = 0 ; j<cols; j++)
                	grid[i][j] = Color.white;
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.setColor(new Color(0, 100, 200));
            g2.fillRect(0,0,d.width,d.height);
 
            //draw grid here
            int xPos=0, yPos=0;
            for (int i = 0 ; i<rows; i++) {
                for (int j = 0 ; j<cols; j++) {
                	g2.setColor(grid[i][j]);
                	g2.fillOval(xPos, yPos, cellSize, cellSize);
                	xPos += cellSize;
                }
                yPos +=cellSize;
                xPos =0;
            }
      
            
            
        }

        public void mousePressed(MouseEvent e) {
        	
        	// drop a checker
            int x = e.getX();
            int col = x / cellSize;
            int row = getRow(col);

            turn++;
            if (turn % 2 == 0) 
                grid[row][col] = Color.red;
            else
                grid[row][col] = Color.yellow;
            
            repaint();
        }

        public int getRow(int col) {
            int r = rows - 1;
            while (r >= 0) {
                if (grid[r][col].equals(Color.white))
                    return r;
                r--;    
            }

            return -1;
        }

                
		public void mouseReleased(MouseEvent e) {
		
		}

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {
           
        }

        public void mouseClicked(MouseEvent e) {

        }
        

        public void reset(){
        	//  reset
            
                
            
        }

		
    }
}