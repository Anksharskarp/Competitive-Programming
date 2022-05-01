package JavaClass13;

/*
We will create a counter program that will start counting by 0's, 1's, 2's, etc.
The User Interface (UI) will be built using JFrame and other JavaFX graphical
user interface tools. You may use the tools and code that we used last class.
-----
We will need to maintain 3 different counter variables.
*/
/*
NOTE: 
We will finish this program in Class14
*/
import java.awt.*;
import javax.swing.*;

public class Class13Part3 extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1528381673975130910L;
    /*
    All of these are text fields and button objects that we can use. They
    were imported from JFrame.
    When you are writing larger programs, be careful with the access allowance
    fields. Private is more secure -- it ensures other programs cannot change
    your data, but it can cause some errors if used improperly.
    */

    //We need to add the fields to our panel (the window the user sees)
    public Class13Part3() {
        Container container1 = getContentPane();
        container1.add(new JLabel("Counter"));
    }

    public static void main(String[] args) {
        new Class13Part3();
    }
}
