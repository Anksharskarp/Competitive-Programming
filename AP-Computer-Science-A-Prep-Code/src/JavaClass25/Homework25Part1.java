package JavaClass25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homework25Part1 {
    private final JFrame frame;

    public Homework25Part1() {
        frame = new JFrame("DrawGrid");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new cPanel(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new Homework25Part1();
    }

    public static class cPanel extends JPanel  implements MouseListener {
        /**
         *
         */
        private static final long serialVersionUID = -4671393023480956134L;
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
            //1. initialize array here
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = Color.white; 
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.setColor(new Color(0, 100, 200));
            g2.fillRect(0,0,d.width,d.height);
 
            //2) draw grid here
           int posX = 0, posY = 0;
           for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    g2.setColor(grid[row][col]);
                    g2.fillOval(posX,posY,cellSize,cellSize);
                    posX += cellSize;
                }
                posY += cellSize;
                posX = 0;
            }

            g2.setColor(new Color(255, 255, 255));
            if(!winner){
                if(turn%2==0)
                    g2.drawString("Red's Turn",500,20);
                else
                    g2.drawString("Yellow's Turn",500,20);
            }else{
                g2.drawString("WINNER - "+ ccolor,500,20);
            }

        }

        public void mousePressed(MouseEvent e) {
        
        // 3. drop a checker
            int x = e.getX();
            int y = e.getY();
            if(!winner){
                if(x<(cellSize*grid[0].length) && y<(cellSize*grid.length)){
                   // int clickedRow = y/cellSize;
                    int clickedCol = x/cellSize;
                    int clickedRow;
                    
                    clickedRow = getRow(clickedCol);

                    if(clickedRow!=-1){

                        if(turn%2==0){
                            grid[clickedRow][clickedCol]= Color.red;
                            ccolor =  "RED";
                        } else{
                            grid[clickedRow][clickedCol]= Color.yellow;
                            ccolor =  "Yellow";
                        }
                        turn++;
                        if(checkForWinner()){
                               winner=true;

                        }
                    }
                }
                repaint();
            }
        }

        public int getRow(int cc){
            int cr = grid.length-1;

            while(cr>=0){ 

                if(grid[cr][cc].equals(Color.white)){
                    return cr;
                }
                cr--;
            }

            return -1;

        }

public void mouseReleased(MouseEvent e) {
}

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
            reset();
            repaint();
        }

        public void mouseClicked(MouseEvent e) {
        }
        
        
        public boolean  checkForWinner(){
            //4 check winner
        
        for (int i = 0; i<grid.length; i++)
        for (int j = 0; j<grid[i].length-3; j++)
        {
        if (grid[i][j] ==  Color.white)
        continue;
        if (grid[i][j] == grid[i][j+1] &&  grid[i][j] == grid[i][j+2] && grid[i][j] == grid[i][j+3])  
        return true;
        }
           for (int i = 0; i<grid.length-3; i++)
        for (int j = 0; j<grid[i].length; j++)
        {
        if (grid[i][j] ==  Color.white)
        continue;
        if (grid[i][j] == grid[i+1][j] &&  grid[i][j] == grid[i+2][j] && grid[i][j] == grid[i+3][j])  
        return true;
        }
      
        for (int i = 0; i<grid.length-3; i++)
        for (int j = 0; j<grid[i].length-3; j++)
        {
        if (grid[i][j] ==  Color.white)
        continue;
        if (grid[i][j] == grid[i+1][j+1] &&  grid[i][j] == grid[i+2][j+2] && grid[i][j] == grid[i+3][j+3])  
        return true;
        }
        
           for (int i = 3; i<grid.length; i++)
        for (int j = 0; j<grid[i].length-3; j++)
        {
        if (grid[i][j] ==  Color.white)
        continue;
        if (grid[i][j] == grid[i-1][j+1] &&  grid[i][j] == grid[i-2][j+2] && grid[i][j] == grid[i-3][j+3])  
        return true;
        }
                  
            return false;
        }

        public void reset(){
        // 5 reset
            winner=false;
            turn=2;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    grid[row][col] = Color.white; 

                }
            }
        }
    }
}
