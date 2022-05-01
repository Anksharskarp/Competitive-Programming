package JavaClass29;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Homework29Part1 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -7497647075828589576L;
    JButton[] buttons;
    int numButtons;
    String[] buttonSymbols;
    JLabel label1;
    
    int numClicks = 0;
    int targetX, targetY;
    
    public Homework29Part1() {
    setTitle("Treasure Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(0, 10)); // 0 means any number of rows, 10 means 10 columns. ATTENTION!!! if you set (10, 10), then it will create 10 rows, but 11 columns per row

    setPreferredSize(new Dimension(1000, 500));
    //setSize(800, 600);

        numButtons = 100 ;
        buttons = new JButton[numButtons];
        buttonSymbols = new String[100];
        
        Random gen = new Random();
        targetX = gen.nextInt(10);
        targetY = gen.nextInt(10);
        
        for (int i =0; i < 100; i++) {
            //buttonSymbols[i] = new String(symbols[i]);
            buttons[i] = new JButton("");
            buttons[i].addActionListener(new ButtonListener());
            add(buttons[i]);
            }

        label1 = new JLabel();
        label1.setSize(1000, 50);
        add(label1);
        
        pack();
        setVisible(true);

    }


    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
                        
            numClicks++;
            System.out.println(numClicks);
            
            for (int i = 0; i < numButtons; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setFont(new Font("Dialog", Font.PLAIN, 50));
                    int x = i/10;
                    int y = i%10;
                    System.out.println(x + " "+y+" "+ targetX+" "+ targetY);
                    int distance = (int)(Math.sqrt((x-targetX)*(x-targetX) +(y-targetY)*(y-targetY)));
                  //buttonSymbols[i]= String.valueOf((int)(Math.sqrt((x-targetX)*(x-targetX) +(y-targetY)*(y-targetY))));  
                    
                    buttonSymbols[i]= String.valueOf(distance);
                    
                    buttons[i].setText(buttonSymbols[i]);
                    if (distance == 0) {
                    label1.setText("You found it!!!");
                    buttons[i].setBackground(Color.RED);
                    }
                    
                }
            }
         }
    }

    public static void main(String[] args) {
        new Homework29Part1();
    }
}




