package JavaClass3;

import java.util.Scanner;

public class Homework3Part2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a year: ");
        int year = s.nextInt();
        if (year % 4 == 0) 
        {
            if (year % 100 == 0)
            { 
                if (year % 400 == 0) 
                    System.out.println("This is a leap year");
                else
                    System.out.println("This is not a leap year");
            }
            else 
                System.out.println("This is a leap year");
        }
        else
            System.out.println("This is not a leap year");
        s.close();
    }
}