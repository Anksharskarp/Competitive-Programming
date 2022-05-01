package JavaClass1;

import java.util.Scanner;
public class Homework1Part2 
{
    public static void main(String[] args) 
    {
        int num;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number you want to check:");
        num = s.nextInt();
        s.close();
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i)
        {
            //Conditions for nonprime number
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");

    }

}