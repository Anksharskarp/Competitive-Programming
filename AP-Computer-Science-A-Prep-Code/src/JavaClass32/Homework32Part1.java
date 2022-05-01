package JavaClass32;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

public class Homework32Part1 extends JFrame {
    private final JTextField AMOUNT_FIELD = new JTextField(12);
    private final Document AMOUNT_TEXT = AMOUNT_FIELD.getDocument();
    private final JTextArea REPORT = new JTextArea(8, 40);

    public Homework32Part1() {
        setSize(500, 500);
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Amount:"));
        topPanel.add(AMOUNT_FIELD);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(REPORT));

        setBackground(Color.LIGHT_GRAY);
        setTitle("Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        AMOUNT_TEXT.addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                showResult();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showResult();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showResult();
            }

        });
    }

    public void showResult() {
        try {
            int amount = Integer.parseInt(AMOUNT_TEXT.getText(0, AMOUNT_TEXT.getLength()));
            REPORT.setText("To make this amount of change, you will need: \n");

            int numQuarters = amount / 25;
            REPORT.append(numQuarters + " quarters;");
            amount %= 25;

            int numDimes = amount / 10;
            REPORT.append(numDimes + " dimes;");
            amount %= 10;

            int numNickels = amount / 5;
            REPORT.append(numNickels + " nickels;");
            amount %= 5;

            int numPennies = amount;
            REPORT.append(numPennies + " pennies;");

        } catch (NumberFormatException | BadLocationException e) {
            REPORT.setText("Please input an integer (number of cents).");
        }
    }

    public static void main(String[] args) {
        new Homework32Part1();

    }
}