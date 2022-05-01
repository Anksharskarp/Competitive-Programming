package JavaClass31;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Class31Part5 extends JFrame {

    JButton bStart, bStop;
    long startTime, detectTime;

    public Class31Part5() {
        setSize(1000, 800);
        setLayout(new GridLayout(0, 2));

        JButton b1 = new JButton("Player1");
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });

        add(b1);

        JLabel result1 = new JLabel();
        add(result1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Class31Part5();
    }
}
