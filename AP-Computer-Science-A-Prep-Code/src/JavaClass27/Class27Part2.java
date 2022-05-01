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

public class Class27Part2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -3613819129640048071L;
    JButton bStart;
    JButton bStop;
    long startTime;
    long stopTime;

    public Class27Part2() {
        setSize(400, 400);
        setLayout(new GridLayout(2, 2));

        JLabel label1 = new JLabel("Response Time: ");
        add(label1);

        JLabel label2 = new JLabel("Message will show here: ");
        add(label2);

        bStart = new JButton("Start");
        bStart.setBackground(Color.RED);
        bStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int millis = (int) (Math.random() * 10000);
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                Container c = getContentPane();
                c.setBackground(new Color((int) (Math.random() * 0x1000000)));

                startTime = System.currentTimeMillis();
                System.out.println("Start Time: " + startTime);
            }

        });

        add(bStart);

        bStop = new JButton("Stop");
        bStop.setBackground(Color.BLUE);
        bStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stopTime = System.currentTimeMillis();
                System.out.println("Stop time: " + stopTime);
                System.out.println("Gap(milliseconds): " + (stopTime - startTime));
                System.out.println("Gap(seconds): " + ((double)(stopTime - startTime) / (double)1000));

                double gap = (double)(stopTime - startTime) / (double)1000;

                if (gap < 0.2) {
                    System.out.println("Well done!");
                } else if (gap >= 0.2 && gap <= 0.4) {
                    System.out.println("Nice!");
                } else if (gap > 0.4 && gap < 0.6) {
                    System.out.println("Could be better...");
                } else if (gap >= 0.6 && gap <= 1.0) {
                    System.out.println("Have you been drinking?");
                } else {
                    System.out.println("Did you fall asleep? WAKE UP!");
                }
                System.out.println("--------------------------------------------------");
            }

        });
        add(bStop);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Class27Part2();
    }
}