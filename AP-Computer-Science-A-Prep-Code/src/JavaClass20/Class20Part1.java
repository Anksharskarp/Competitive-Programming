package JavaClass20;

/*
A simple painting app that allows the user to 
switch between different colors.
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Random;

public class Class20Part1 extends JFrame implements MouseMotionListener{
    /**
     *
     */
    private static final long serialVersionUID = 8860024346914758283L;

    JButton bRed;
    JButton bBlue;
    JButton bRandom;
    String color = "black";

    public Class20Part1() {
            addMouseMotionListener(this);
            setSize(400, 400);
            setLayout(new FlowLayout());
            //Red color button
            bRed = new JButton("Red");
            bRed.setBackground(Color.RED);
            bRed.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = "red";
                }
                   
            });
            add(bRed);
            //Blue color button
            bBlue = new JButton("Blue");
            bBlue.setBackground(Color.BLUE);
            bBlue.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = "blue";
                }
                   
            });
            add(bBlue);
            //Random color button
            bRandom = new JButton("Random");
            bRandom.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = "random";
                }
                   
            });
            add(bRandom);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }
    @Override
    public void mouseDragged(MouseEvent e){
        Graphics g = getGraphics();
        if(color.equals("red")) {
            g.setColor(Color.red);
        } else if(color.equals("blue")) {
            g.setColor(Color.blue);
        } else if(color.equals("random")) {
            Random r = new Random();
            float cr = r.nextFloat();
            float cg = r.nextFloat();
            float cb = r.nextFloat();
            g.setColor(new Color(cr, cg, cb));
        }

        g.fillOval(e.getX(), e.getY(), 20, 20);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    public static void main (String[]args){
        new Class20Part1();
    }
}