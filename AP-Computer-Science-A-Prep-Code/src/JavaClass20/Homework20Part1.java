package JavaClass20;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.*;
import java.util.*;

public class Homework20Part1 extends JFrame implements MouseMotionListener {


    /**
     *
     */
    private static final long serialVersionUID = 8036201964885425951L;
    
    JButton bRed, bBlue, bRandom;
    String color = "black";
    JSlider sSize;
    int penSize = 10;

    Homework20Part1() {
        addMouseMotionListener(this);
        setSize(400, 400);
        setLayout(new FlowLayout());

        bRed = new JButton("Red");
        bRed.setBackground(Color.RED);
        bRed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                color = "red";
            }

        });

        add(bRed);

        bBlue = new JButton("Blue");
        bBlue.setBackground(Color.BLUE);
        bBlue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                color = "blue";
            }

        });
        add(bBlue);

        bRandom = new JButton("Random");

        bRandom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                color = "random";
            }

        });
        add(bRandom);

        sSize = new JSlider(0, 100);


        sSize.setMajorTickSpacing(25);
        sSize.setMinorTickSpacing(10);
        sSize.setPaintTicks(true);

        // Set the labels to be painted on the slider
        sSize.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(25, new JLabel("25"));
        position.put(50, new JLabel("50"));
        position.put(75, new JLabel("75"));
        position.put(100, new JLabel("100"));

        // Set the label to be drawn
        sSize.setLabelTable(position);

        sSize.addMouseMotionListener(new MouseMotionListener() {


            @Override
            public void mouseDragged(MouseEvent e) {

                penSize = sSize.getValue();
            }

            @Override
            public void mouseMoved(MouseEvent e) {


            }

        });
        add(sSize);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        if (color.equals("red"))
            g.setColor(Color.red);
        else if (color.equals("blue"))
            g.setColor(Color.blue);
        else if (color.equals("random")) {
            Random r = new Random();
            float cr = r.nextFloat();
            float cg = r.nextFloat();
            float cb = r.nextFloat();
            g.setColor(new Color(cr, cg, cb));
        }

        g.fillOval(e.getX(), e.getY(), penSize, penSize);
    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }

    public static void main(String[] args) {
        new Homework20Part1();
    }
}
