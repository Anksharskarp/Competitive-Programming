package intermediate.homework.Homework1;

import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String message, int shift) {
        String encrypted = "";

        shift %= 26;

        final int length = message.length();
        for(int i = 0; i < length; i++) {

            char current = message.charAt(i);

            if (IsUppercase(current)) {
                current += shift;
                encrypted += (char) (current > 'Z' ? current - 26 : current);
            } else if (IsLowercase(current)) {
                current += shift;
                encrypted += (char) (current > 'z' ? current - 26 : current);
            } else {
                encrypted += current;
            }
        }
        return encrypted;
    }

    public static String decrypt(String encryptedMessage, int shift) {
        String decoded = "";

        shift %= 26;

        final int length = encryptedMessage.length();
        for(int i = 0; i < length; i++) {
            char current = encryptedMessage.charAt(i);
            if(IsUppercase(current)) {

                current -= shift;
                decoded += (char) (current < 'A' ? current + 26 : current); // 26 = number of latin letters

            } else if(IsLowercase(current)) {

                current -= shift;
                decoded += (char) (current < 'a' ? current + 26 : current); // 26 = number of latin letters

            } else {
                decoded += current;
            }
        }
        return decoded;
    }

    private static boolean IsUppercase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean IsLowercase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the message (ignore punctuation)");
        String message = input.nextLine();
        System.out.println(message);
        System.out.println("Please enter the shift number");
        int shift = input.nextInt() % 26;
        System.out.println("(E)crypt or (D)ecrypt ?");
        char choice = input.next().charAt(0);
        switch(choice) {
            case 'E':
            case 'e':
                System.out.println("ENCRYPTED MESSAGE IS \n" + encrypt(message, shift));
                break;
            case 'D':
            case 'd':
                System.out.println("DECRYPTED MESSAGE IS \n" + decrypt(message, shift));
            default:
                System.out.println("INVALID INPUT: PLEASE TRY AGAIN");
        }
        input.close();
    }
}

