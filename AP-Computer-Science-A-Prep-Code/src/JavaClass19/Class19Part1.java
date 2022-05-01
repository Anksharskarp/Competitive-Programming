package JavaClass19;

/*
This program creates an automatic voting machine that tallies up 
votes from clicking on the "Trump" and "Biden" buttons, respectively.
*/

import java.awt. * ;
import java.awt.event. * ;
import javax.swing. * ;

import java.net.MalformedURLException;
import java.net.URL;

public class Class19Part1 extends JFrame {

      /**
    	 *
    	 */
    private static final long serialVersionUID = -7216323447258186761L;
    JButton[] buttons = new JButton[2];
    JLabel jl1 = new JLabel("Result");

    int countTrump = 0,
    countBiden = 0;

    public Class19Part1() throws MalformedURLException {

        Container c1 = getContentPane();
        c1.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel(new GridLayout(1, 2));

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(new URL("https://freesvg.org/img/Donald-Trump-Official-White-House-Photograph.png")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));

        buttons[0] = new JButton(imageIcon);

        buttons[0].addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            countTrump++;
            jl1.setText("Result:  Trump: " + countTrump + " Biden: " + countBiden);

      }
    });

    p1.add(buttons[0]);

    imageIcon = new ImageIcon(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/f/f4/Joe_Biden_official_portrait_2013.jpg")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));

    //imageIcon = new ImageIcon(new URL("https://pngriver.com/wp-content/uploads/2019/06/Official_portrait_of_Vice_President_Joe_Biden-removebg.png"));
    buttons[1] = new JButton(imageIcon);

    buttons[1].addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent evt) {
        countBiden++;
        jl1.setText("Result:  Trump: " + countTrump + " Biden: " + countBiden);

      }
    });

    p1.add(buttons[1]);
    add(p1);

    JPanel p2 = new JPanel(new FlowLayout());

    p2.add(jl1);
    add(p2);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000, 1000);
    setVisible(true);

  }

  public static void main(String[] args) throws MalformedURLException {
    new Class19Part1();
  }

}
