package JavaClass31;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Homework31Part1 extends JFrame {

    JButton bPlayer1, bPlayer2;
    String[] dice = {"⚀", "⚁", "⚂", "⚃", "⚄", "⚅"};
    int d11, d12, d21, d22;

    public Homework31Part1() {
        setSize(400, 400);
        setLayout(new GridLayout(3, 2));
        JLabel label1 = new JLabel();
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        JLabel dice1 = new JLabel();
        JLabel dice2 = new JLabel();


        bPlayer1 = new JButton("Player1");
        bPlayer1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Random gen = new Random();
                d11 = gen.nextInt(6);
                d12 = gen.nextInt(6);
                dice1.setText(dice[d11] + " " + dice[d12]);

            }

        });

        add(bPlayer1);

        dice1.setText("dice1 ");
        dice1.setFont(new Font("TimesRoman", Font.PLAIN, 60));
        add(dice1);

        bPlayer2 = new JButton("Player2");

        bPlayer2.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                Random gen = new Random();
                d21 = gen.nextInt(6);
                d22 = gen.nextInt(6);
                dice2.setText(dice[d21] + " " + dice[d22]);

                if (d21 + d22 > d11 + d12)
                    label1.setText(" Player2 Wins!");
                else if (d21 + d22 < d11 + d12)
                    label1.setText(" Player1 Wins!");
                else
                    label1.setText(" It's a tie!");


            }

        });

        add(bPlayer2);

        dice2.setText("dice2");
        dice2.setFont(new Font("TimesRoman", Font.PLAIN, 60));
        add(dice2);

        add(label1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Homework31Part1();
    }
}
