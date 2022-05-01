package JavaClass1;

import java.util.Scanner;
public class Homework1Part1 
{
    public static void main(String[] args) 
    {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number you want to check:");
        n = s.nextInt();
        s.close();
        if(n % 2 == 0)
        {
            System.out.println("The entered number "+n+" is even ");
        }
        else
        {
            System.out.println("The entered number "+n+" is odd ");
	}
    }
}