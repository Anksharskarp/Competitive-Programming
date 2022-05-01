package JavaClass2;

import java.util.Scanner;

public class Homework2Part3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int decimal;
        int count = 0;
        String word = "";
        System.out.println("Please enter a Decimal Number: ");
        decimal = s.nextInt();
        while (decimal > 0) {
            count = decimal % 2;
            word = count + word;
            decimal = decimal / 2;
        }
        System.out.println("Binary number is: " + word);
        s.close();
    }
}