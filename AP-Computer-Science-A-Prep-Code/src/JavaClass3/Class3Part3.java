package JavaClass3;

import java.util.Scanner;

public class Class3Part3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the day of the week (1-7)");
        int num = s.nextInt();
        // Switch only changes based on what the 
        // variable is exactly equal to
        // break; removes the last condition...
        switch (num) {
            case 1:
                System.out.println("It's Monday");
                break;
            case 2:
                System.out.println("It's Tuesday");
                break;
            case 3:
                System.out.println("It's Wednesday");
                break;
            case 4:
                System.out.println("It's Thursday");
                break;
            case 5:
                System.out.println("It's Friday");
                break;
            case 6:
                System.out.println("It's Saturday");
            case 7:
                System.out.println("It's Sunday");
            default:
                System.out.println("Invalid input");
        }
        s.close();
    }
}