package JavaClass3;

import java.util.Scanner;

public class Class3Part2 {
    public static void main(String[] args) {
        // Write a program that prompts user to enter a number n 
        // and prints a multiplication table of size n * n
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int num = s.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) 
                System.out.print(j * i + "\t");
        System.out.println();
            
        
        }
        s.close();
    }
}