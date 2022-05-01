package JavaClass2;

import java.util.Scanner;

public class Class2Part4 {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your age: ");

        int age = s.nextInt();
        s.close();
        if (age < 13)
            System.out.println("You can't watch a PG13 movie by yourself!");
        else
            System.out.println("Go ahead, enjoy the movie.");


    }
}