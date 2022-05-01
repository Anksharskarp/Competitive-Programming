package JavaClass15;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 
//Find all numbers between 1-10,000 with the following feature: 
//the sum of the cubes of its digits is equal to the number itself.

public class Homework15Part1 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1579380284010870903L;
    private final JTextField field1;
    private final JTextField field2;
    private JTextField field3;
    private final JButton button1;
   
    public Homework15Part1() {
	    Container c1 = getContentPane();
	    c1.setLayout(new FlowLayout());
        c1.add(new JLabel("Fahrenheit"));
        field1 = new JTextField(10);
        c1.add(field1);
        //field2 = new JTextField(10);
        //c1.add(field2);
        c1.add(new JLabel("Celsius"));
        field2 = new JTextField(10);
        c1.add(field3);
        button1 = new JButton("Convert");
        c1.add(button1); 
        button1.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
        double f = Double.parseDouble(field1.getText());
        double c = (f - 32) * 5 / 9;
        String fahrenheit = String.valueOf(f);
        String celsius = String.valueOf(c);
        field1.setText(fahrenheit);
        field2.setText(celsius);
	}

    	 
     });
     setSize(600, 600);
     setVisible(true);

   }
   	
   public static void main(String[] args) {
 
	   new Homework15Part1();
   }
}