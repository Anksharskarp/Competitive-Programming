package JavaClass3;

import java.util.Scanner;

public class Class3Part4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the day of the week (1-7)");
        int num = s.nextInt();
        switch (num) {
            case 1:
                
            case 2:
                
            case 3:
                
            case 4:
                
            case 5:
                System.out.println("It's a weekday");
                break;
            case 6:
                
            case 7:
                System.out.println("It's a weekend");
                break;
            default:
                System.out.println("Invalid input");
        }
        s.close();
    }
}