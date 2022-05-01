package JavaClass3;

public class Class3Part7 {
    //Let's get started with methods!
    //Otherwise known as...functions!
    //Should be static though...
    public static void displayDiamond(String s) {
        // REMEMBER TO CORRECT AND FIX JULY 1ST
        for (int i = 1; i >= 10; i++) {
            for (int j = 1; j <=i; j++) 
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(s + s);
            System.out.println();
        }
        //Don't forget to define j!!!
        for (int i = 10; i >= 1; i--) {
            for (int j = 1; j <=i; j++) 
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(s + s);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        displayDiamond("$");
        displayDiamond("#");
    }
}