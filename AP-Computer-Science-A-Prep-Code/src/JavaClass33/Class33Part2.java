package JavaClass33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Class33Part2 extends JPanel implements ActionListener {

    static int score = 0;
    static int xPos, yPos;
    static int rounds = 0;
    Timer t = new Timer(1000, this);

    public static void main(String[] args) {

        Class33Part2 c = new Class33Part2();
        System.out.println("here");
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(700, 700);
        j.getContentPane().setBackground(Color.green);
        j.add(c);
        c.setOpaque(false);
        j.setVisible(true);


        j.addMouseListener(new MouseAdapter() {

            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + "," + e.getY() + " ," + xPos + " , " + yPos);
                if ((e.getX() >= xPos) && (e.getX() <= xPos + 100) && (e.getY() >= yPos) && (e.getY() <= yPos + 100)) {
                    System.out.println("got it");
                    score++;
                }
            }
        });
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (rounds < 30) {

            rounds++;
            Color currentColor = new Color(0, (int) (255 - (Math.random() * 20)), 0);

            g.setColor(currentColor);
            xPos = (int) (Math.random() * 500);
            yPos = (int) (Math.random() * 500);
            g.fillRect(xPos, yPos, 100, 100);
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.BOLD, 50));
            g.drawString("Score: " + score + " Rounds: " + rounds, 0, 50);
            t.start();

        } else {

            g.setFont(new Font("TimesRoman", Font.BOLD, 50));
            g.drawString("Your accuracy is :  " + String.format("%.2f", ((double) score) / rounds), 100, 300);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();// this will call at every 1 second
    }

}



