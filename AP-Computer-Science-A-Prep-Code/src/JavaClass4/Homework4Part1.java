package JavaClass4;

import java.util.Scanner;

public class Homework4Part1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        String input = s.nextLine();
        int stringLength = input.length();
        boolean isPalindrome = true;

        for (int i = 0; i < stringLength; i++) {
            if (input.charAt(i) != input.charAt(stringLength - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is not a palindrome");
        }
        s.close();
    }
}