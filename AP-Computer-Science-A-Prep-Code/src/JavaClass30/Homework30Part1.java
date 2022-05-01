package JavaClass30;

import java.awt.*;

import javax.swing.JFrame;

public class Homework30Part1 extends Canvas{


    public static void main(String[] args) {
        JFrame frame = new JFrame("My Graph");
        Canvas c = new Homework30Part1();
        c.setSize(400, 400);
        frame.add(c);
        frame.pack();
        frame.setVisible(true);

    }

    public void paint(Graphics g) {
        Rectangle boundingBox = new Rectangle(0, 0, 20, 20);
        drawOval(g, boundingBox, 1);



    }

    public void drawOval(Graphics g, Rectangle r, int ascending) {
        g.setColor(Color.red);

        int radius = r.width/2;

        int rval = (int)Math.floor(Math.random() * 255);
        int gval = (int)Math.floor(Math.random() * 255);
        int bval = (int)Math.floor(Math.random() * 255);

        //g.setColor(new Color(rval,gval, bval));

        g.fillOval(r.x, r.y, r.width, r.height);
        Rectangle next;
        System.out.print(ascending);
        //Rectangle next=new Rectangle(r.x+r.width,  r.y+((int) (0.1*r.width)), (int) (r.width*0.8), (int) (r.height*0.8));
        if ( ascending == 1)
            next =new Rectangle(r.x+r.width,  r.y, (int) (r.width*1.2), (int) (r.height*1.2));
        else
            next=new Rectangle(r.x+r.width,  r.y, (int) (r.width*0.8), (int) (r.height*0.8));

        if ( ascending == 1) {
            if (radius >50)
                ascending = -1;
        }
        else
        if (radius <10)
            return;

        drawOval(g, next, ascending);

    }

}

