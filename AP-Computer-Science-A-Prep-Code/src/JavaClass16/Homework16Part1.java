package JavaClass16;

import java.awt.*;
import java.awt.event. * ;
import javax.swing. * ;

public class Homework16Part1 extends JFrame {

  /**
    *
    */
  private static final long serialVersionUID = 1L;
  JButton[] buttons = new JButton[9];
  int turn = 0;

  public Homework16Part1() {

    Container c1 = getContentPane();
    c1.setLayout(new GridLayout(3, 3));

    for (int i = 0; i <= 8; i++) {
      buttons[i] = new JButton("");
      buttons[i].addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {

          JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
          String winner;

          if (turn % 2 == 0) {
            buttonClicked.setText("X");
            winner = "X";
          }
          else {
            buttonClicked.setText("O");
            winner = "O";
          }

          if (checkForWin()) {
            JOptionPane.showConfirmDialog(null, "Game Over. Winner is : " + winner);
            for (int i = 0; i <= 8; i++) {
              buttons[i].setText("");
            }
          }

          turn++;

        }
      });

      add(buttons[i]);
    }

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 100);
    setVisible(true);

  }

  public boolean checkForWin() {
    if (isSame(0, 1, 2) || isSame(3, 4, 5) || isSame(6, 7, 8)) return true;
    if (isSame(0, 3, 6) || isSame(1, 4, 7) || isSame(2, 5, 8)) return true;
    return isSame(0, 4, 8) || isSame(2, 4, 6);
  }

  public boolean isSame(int a, int b, int c) {
    return buttons[a].getText().equals(buttons[b].getText()) && buttons[b].getText().equals(buttons[c].getText()) && !buttons[a].getText().equals("");
  }

  public static void main(String[] args) {
    new Homework16Part1();
  }

}




