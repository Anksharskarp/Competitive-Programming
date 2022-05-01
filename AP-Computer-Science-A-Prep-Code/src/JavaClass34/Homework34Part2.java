package JavaClass34;

import javax.swing.*;
import java.awt.*;

public class Homework34Part2 extends JPanel {


    public static void main(String[] args) {

        Homework34Part2 b = new Homework34Part2();

        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(700, 700);
        j.add(b);
        j.setVisible(true);


    }


    public void paintComponent(Graphics g) {
        //Parameters
        int block_len = 50;
        int block_height = 20;
        int middle = 250;
        int pyramid_height = 10;
        int x_pos;

        for (int stage = 1; stage < pyramid_height; stage++) {


            //Starting pos of block
            if (stage % 2 == 1) {
                x_pos = middle - stage / 2 * block_len - block_len / 2;
            } else {
                x_pos = middle - stage / 2 * block_len;
            }

            //Draw the block
            for (int row = 1; row < stage + 1; row++) {
                g.drawRect(x_pos, stage * block_height, block_len, block_height);
                x_pos += block_len;
            }


        }
    }
}



