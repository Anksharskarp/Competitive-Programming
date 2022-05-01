package JavaClass26;

import javax.swing.*;
import java.awt.*;

public class Class26Part1 {
    private final JFrame frame;

    public Class26Part1() {
        frame = new JFrame("DrawGrid");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new cPanel(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new Class26Part1();
    }

    public static class cPanel extends JPanel {       
        
        /**
         *
         */
        private static final long serialVersionUID = 8017218446654843241L;

        public cPanel(Dimension dimension) {
            setSize(dimension);            
        }

        @Override
        public void paintComponent(Graphics g) {
        	drawYinYang(g, 100, Color.black, Color.white);
        }


        public void drawYinYang(Graphics g, int diameter, Color c1, Color c2) {

        	Graphics2D g2 = (Graphics2D)g;
            
            g2.setColor(c1); 
            g2.fillArc(0, 0, diameter, diameter, 0, 180);
            g2.setColor(c2); 
            g2.fillArc(0, 0, diameter, diameter, 0, -180);
            
            g2.setColor(c2); 
            g2.fillArc(0, diameter/4, diameter/2, diameter/2, 0, 180);
 
            g2.setColor(c1); 
            g2.fillArc(diameter/2, diameter/4,  diameter/2,  diameter/2, 0, -180);

            g2.setColor(c1); 
            g2.fillArc(diameter/4-diameter/8, diameter/2-diameter/8, diameter/4, diameter/4, 0, 360);
 
            g2.setColor(c2); 
            g2.fillArc(diameter*3/4 - diameter/8, diameter/2-diameter/8, diameter/4, diameter/4, 0, 360);

        }
    }
    
}