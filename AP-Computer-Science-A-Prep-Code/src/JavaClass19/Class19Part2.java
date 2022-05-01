package JavaClass19;

/*
This program creates a simple timer application with a "Start"
and "Stop" button that displays the time elapsed since the 
"Start" button was pressed.
*/

import java.awt. * ;
import java.awt.event. * ;
import javax.swing. * ;
import java.util.Timer;
import java.util.TimerTask;

public class Class19Part2 extends JFrame {

      /**
    	 *
    	 */
    private static final long serialVersionUID = -7216323447258186761L;
    JButton[] buttons = new JButton[2];
    JLabel jl1 = new JLabel();
    Timer t;
    long startTime;

    int countTrump = 0,
    countBiden = 0;

    public Class19Part2() {

        Container c1 = getContentPane();
        c1.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel(new GridLayout(1, 2));

        //ImageIcon imageIcon = new ImageIcon(new ImageIcon(new URL("https://freesvg.org/img/Donald-Trump-Official-White-House-Photograph.png")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));

        buttons[0] = new JButton("Start");

        buttons[0].addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            t = new Timer();
            startTime = evt.getWhen();
            t.schedule(new TimerTask() {
                public void run() {
                    jl1.setText("Time Elapsed:  " + (System.currentTimeMillis() - startTime) + " ms");
                }
        }, 0, 10);

      }
    });

    p1.add(buttons[0]);

    buttons[1] = new JButton("Stop");

    buttons[1].addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent evt) {
        t.cancel();
        jl1.setText("Time Elapsed:  " + (System.currentTimeMillis() - startTime) + " ms");

        }
        });

    p1.add(buttons[1]);
    add(p1);

    JPanel p2 = new JPanel(new FlowLayout());

    p2.add(jl1);
    add(p2);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(200, 100);
    setVisible(true);

  }

  public static void main(String[] args) {
    new Class19Part2();
  }

}
