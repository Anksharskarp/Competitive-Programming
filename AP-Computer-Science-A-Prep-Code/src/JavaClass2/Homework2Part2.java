package JavaClass2;

import java.util.Scanner;

public class Homework2Part2 {
    public static void main(String[] args) {
        int sum = 0;
        int num = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("Amount of numbers to compute average: ");
        int howManyTimes = s.nextInt();
        while (num <= howManyTimes) {
            System.out.println("Input number " + "(" + num + ")" + ":");
            sum += s.nextInt();
            num += 1;
        }
        double average = (sum / howManyTimes);
        System.out.println("The average of the numbers is: " + average);
        s.close();
    }
}