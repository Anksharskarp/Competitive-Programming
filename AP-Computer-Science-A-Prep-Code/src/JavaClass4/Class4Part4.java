package JavaClass4;

import java.awt.*; //Abstract Window Toolkit
import javax.swing.JFrame; //Generates a window frame in Java
//Develops GUI in Java

public class Class4Part4 extends Canvas{ //Our class extends the exist class, Canvas
    /**
     *
     */
    private static final long serialVersionUID = -1629591080594733801L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Painting");
        Canvas c = new Class4Part4(); //Creates instance of the existing class
        c.setSize(400, 400); //Defines the size of your canvas drawing board
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        //Upper left corner is always (0,0) in Java and Javascript
        //Middle point of the entire canvas is always (0,0) in Python
        g.setColor(Color.black);
        g.fillOval(50, 50, 100, 100);
        g.fillOval(100, 100, 200, 200);
        g.fillOval(250, 50, 100, 100);
    }
}