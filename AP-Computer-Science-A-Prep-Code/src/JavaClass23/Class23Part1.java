package JavaClass23;

/*
This is a simple memory matching game written in Java
Enjoy!
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Class23Part1 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 7164103362825187550L;

    // Fill free to fill this array with whatever amount and type of
    //symbols as you please
    String[] symbols = {"\u2660", "\u2661", "\u2662","\u2663", "\u2664", "\u2665",
    "\u2660", "\u2661", "\u2662","\u2663", "\u2664", "\u2665"};

    //String buttonSymbols[];

    JButton[] buttons;

    int numClick = 0;
    int currentIndex;
    int previousIndex;

    Timer myTimer;

    public Class23Part1() {
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, symbols.length));
        setPreferredSize(new Dimension(1000, 500));

        buttons = new JButton[symbols.length];
        //buttonSymbols = new String[symbols.length];

        /*
        This shuffles the symbols
        */
        Random r = new Random();
        for (int i = 0; i < symbols.length; i++) {
            int rand = r.nextInt(symbols.length);
            String temp = symbols[i];
            symbols[i] = symbols[rand];
            symbols[rand] = temp;
        }

        for (int i = 0; i < symbols.length; i++) {
            //buttonSymbols[i] = symbols[i];
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Dialog", Font.BOLD, 50));
            buttons[i].addActionListener(new ButtonListener());
            add(buttons[i]);
        }
        myTimer = new Timer(1000, new TimerListener());

        pack();
        setVisible(true);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttons[currentIndex].setText("");
            buttons[previousIndex].setText("");
            myTimer.stop();
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(myTimer.isRunning()) {
                return;
            }

            numClick++;

            for (int i = 0; i < symbols.length; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setText(symbols[i]);
                    currentIndex = i;
                }
            }

            if (currentIndex == previousIndex) {
                numClick--;
                return;
            }

            //If they are not equal, then we flip them over again
            if (numClick % 2 == 0) {
                if(! symbols[currentIndex].equals(symbols[previousIndex])) {
                    myTimer.restart();
                }
            } else {
                previousIndex = currentIndex;
            }
        }
    }

    public static void main(String[] args) {
        new Class23Part1();
    }
}

