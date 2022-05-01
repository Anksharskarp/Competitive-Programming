package JavaClass16;

/*
Tic-tac-toe program that is very fun!
It has a total of 9 buttons that we can use.
*/
import java.awt.*;
import javax.swing.*;

public class Class16Part2 extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 8613938992844785105L;
    /*
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    */
    private final JButton[] buttons = new JButton[9];

    public Class16Part2() {
        
        Container c1 = getContentPane();
        //We choose grid layout because we want them 
        //to be in a grid shape
        c1.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton(" ");
            c1.add(buttons[i]);
        }

        /*
        button1.addActionListener(new ActionListener() {
        public void actionPerformed(Actionevent evt) {

        }
        });
        */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setVisible(true); //we need to show it
    }

    public static void main(String[] args) {
        new Class16Part2();
    }
}
