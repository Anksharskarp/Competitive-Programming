package JavaClass28;
/*
Chinese Zodiac Sign Finder.
*/

import java.awt.*;
//Be hypervigilant about imports! Make sure it is event,
//not Event, or the ActionListener will NOT work!
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.*;


public class Class28Part1 extends JFrame {
    
    /**
     *
     */
    private static final long serialVersionUID = 4022634425958090350L;

    JButton bStart, bStop;
    
    String[] signs = { "Mouse", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
     "Sheep",  "Monkey", "Rooster", "Dog", "Pig"};
    String[]  icons = {  " 🐀 "   , " 🐂  ", " 🐅 ", " 🐇 ", " 🐉 ", " 🐍 ", " 🐎 ",
     " 🐏 ", " 🐒 ",  " 🐓 ", " 🐕 ", " 🐖 "};
    String[] personalities = {"quick-witted and resourceful", "diligent and dependable" ,
     "ambitious and charming","compassionate and elegant" , "energetic and charismatic",
     "enigmatic and intelligent", "self-reliant and active" , "calm and creative, ", 
     "sharp and curious",  "observant and practical", "lovely and honest",
       "compassionate and generous"};

    public Class28Part1() {
        setSize(1000, 800);
        setLayout(new GridLayout(3, 1));

        JLabel title = new JLabel();
        title.setText("Please enter your birth year (according to the Chinese Calenar): ");
        title.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        add(title);

        JTextField year = new JTextField();
        add(year);

        bStart = new JButton("My Zodiac Sign");
        bStart.addActionListener(new ActionListener() {
        	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int birthYear = Integer.parseInt(year.getText()); 
				System.out.print(birthYear);
				
				int years = birthYear -1900;
				int index = years%12;
				
				title.setText("<html> Your zodiac sign is " + signs[index] + " "+ icons[index] + " <br> You are " + personalities[index] + " </html>") ;
				
			}
        
        });
        add(bStart);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Class28Part1();
    }
}
