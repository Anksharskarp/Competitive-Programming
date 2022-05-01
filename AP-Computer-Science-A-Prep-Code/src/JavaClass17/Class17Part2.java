package JavaClass17;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;


public class Class17Part2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 8738951534769921354L;
    JButton[] buttons = new JButton[2];
    int turn = 0;

    public Class17Part2() throws MalformedURLException {

        Container c1 = getContentPane();
        c1.setLayout(new FlowLayout());


        ImageIcon icon1 = new ImageIcon(new URL("https://freesvg.org/img/Donald-Trump-Official-White-House-Photograph.png"));

        buttons[0] = new JButton(icon1);
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });

        add(buttons[0]);


        icon1 = new ImageIcon(new URL("https://pngriver.com/wp-content/uploads/2019/06/Official_portrait_of_Vice_President_Joe_Biden-removebg-239x300.png"));

        buttons[1] = new JButton(icon1);
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });

        add(buttons[1]);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 100);
        setVisible(true);

    }



    public static void main(String[] args) throws MalformedURLException {
        new Class17Part2();
    }

}