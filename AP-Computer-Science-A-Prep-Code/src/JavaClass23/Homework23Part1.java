package JavaClass23;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Homework23Part1 extends JFrame {

	/**
     *
     */
    private static final long serialVersionUID = 5430459011209625436L;
    String[] symbols = { "\u2660", "\u2661", "\u2662", "\u2663", "\u2664", "\u2665", "\u2666", "\u2667",
								"\u2660", "\u2661", "\u2662","\u2663", "\u2664", "\u2665","\u2666", "\u2667"};
	JButton[] buttons;
	JLabel label;
	int numClick = 0; 
	int currentIndex, previousIndex;
	Timer myTimer ;
	
    public Homework23Part1() {
    	setTitle("Memory Game");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, symbols.length));
    	setPreferredSize(new Dimension(1000, 500));
    	
    	buttons = new JButton[symbols.length];
    	
    	Random r = new Random();
    	for (int i = 0; i<symbols.length; i++) {
    		int rand = r.nextInt(symbols.length);
    		String temp = symbols[i];
    		symbols[i] = symbols[rand];
    		symbols[rand] = temp;
    	}

    	for (int i = 0; i<symbols.length; i++) {
    		//buttons[i] = new JButton(symbols[i]);
    		buttons[i] = new JButton("");
    		buttons[i].setFont(new Font("Dialog", Font.BOLD, 50));
    		buttons[i].addActionListener(new ButtonListener());
    		add(buttons[i]);
    	}
    	myTimer = new Timer(1000, new TimerListener());
    	//label = new JLabel();
    	//add(label);
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
			
			if (myTimer.isRunning())
				return;
			
			numClick++;
			
			
			for (int i = 0; i<symbols.length; i++) {
				if (e.getSource() == buttons[i]) {
					buttons[i].setText(symbols[i]);
					currentIndex = i;
					
				}
			}
			
			if (currentIndex == previousIndex) {
				numClick--;
				return;
				
			}
			if (numClick %2 ==0 ) {
				if (! symbols[currentIndex].equals(symbols[previousIndex])) {
					myTimer.restart();
				}
			}
			else {
				previousIndex = currentIndex;
			}
			
			for(int i=0; i<buttons.length+1; i++) {
				if (i==buttons.length) {
					System.out.println("Hooray! Finished after flipping over cards " + numClick + " times!");
					return;
				}
				if(buttons[i].getText().equals("")) 
					break;
				
			}
		}
      	
    }
    
    
    public static void main(String[] args) {
        new Homework23Part1();
    }
}