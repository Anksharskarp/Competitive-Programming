package JavaClass27;

/*
Response Time Tester:
Test your response time!
Click on "Start" first, and wait until the background
changes. As soon as it changes, hit "stop!"

<0.2s: Well done
[0.2, 0.4]: Nice
(0.4, 0.6): Could be better
[0.6, 1]: Have you been drinking?
>1s: Did you fall asleep?

Enjoy!
*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.*;

public class Homework27Part1 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -6922620778240483727L;
    JButton bStart, bStop;
    long startTime, detectTime;  

    public Homework27Part1(){
        setSize(1000, 800);
        setLayout(new GridLayout(3, 2));

        
        JLabel title = new JLabel();
        title.setText("Response Time: "); 
        title.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        add(title);
      
        JLabel result = new JLabel();
        result.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        result.setText(" Click on 'Start' first, and wait until the background color changes. As soon as it changes, hit \"stop!\""); 
        add(result);
        
        bStart = new JButton("Start");
        bStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//Container c = JFrame.getContentPane();
			try {
			Thread.sleep((int)(Math.random() * 10000));
			} catch (InterruptedException e1) {

			e1.printStackTrace();
			}
			
			Container c = getContentPane();
			Color bgColor = new Color((int)(Math.random() * 0x1000000));
			c.setBackground(bgColor);
			startTime = System.currentTimeMillis();
			//System.out.println(formatter.format(date));
			}
        
        });
        
        add(bStart);
        
        bStop = new JButton("Stop");
        
        bStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			detectTime = System.currentTimeMillis();
			long delay = detectTime - startTime;
			if (delay < 200)
			    result.setText("Delay: "+delay + ". Well Done!");
			else if (delay < 400)
			    result.setText("Delay: "+delay + ". Nice!");
			else if (delay < 600)
			    result.setText("Delay: "+delay + ". Could be better!");
			else if (delay < 1000)
			    result.setText("Delay: "+delay + ". Are you drunk?");
			else
			    result.setText("Delay: "+delay + ". Are you asleep?");
			}
			        
        });
        add(bStop);
       

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
    }
    public static void main (String[]args){
        new Homework27Part1();
    }
}