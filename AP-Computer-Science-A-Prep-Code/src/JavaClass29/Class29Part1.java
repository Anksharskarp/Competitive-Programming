package JavaClass29;

/*
This is a similar program to the memory game that
we made a few classes ago. This is "Treasure Hunt,"
where you get numbers on a board that tell you about 
your current taxicab distance from the treasure, and 
you need to click on it in as few clicks as possible.
*/

import java.awt. * ;
import java.awt.event. * ;
import javax.swing. * ;
import java.util.Random;

public class Class29Part1 extends JFrame {
	/**
     *
     */
    private static final long serialVersionUID = -5996653783506049370L;
    JButton[] buttons;
    int numButtons;
    String[] buttonSymbols;
    Timer myTimer;

    int numClicks = 0;
    int previousIndex = 0;
    int currentIndex = 0;
    //Coordinates of the treasure location.
    int treasureX;
    int treasureY;


    public Class29Part1() {
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 20));
        setPreferredSize(new Dimension(1000, 500));
        // setSize(800, 600);
        numButtons = 400;
        buttons = new JButton[numButtons];

        Random r = new Random();
        //Generates random integers from 0 to 20 on the 20x20 grid of buttons.
        treasureX = r.nextInt(20);
        treasureY = r.nextInt(20);

        for (int i = 0; i < numButtons; i++) {
            buttons[i] = new JButton("");
            buttons[i].addActionListener(new ButtonListener());
            add(buttons[i]);
        }

        pack();
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < numButtons; i++) {
                if(e.getSource() == buttons[i]) {

                    int distance;
                    int row = i / 20;
                    int col = i % 20;

                    distance = (int) Math.sqrt((row - treasureX) * (row - treasureX) + (col - treasureY) * (col - treasureY));

                    buttons[i].setText(String.valueOf(distance));
                }
            }
        }
    }

    public static void main(String[] args) {
        new Class29Part1();
  }
}