package JavaClass2;

import java.util.Scanner;

public class Class2Part6 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("I have a number in my mind, guess what it is.");
        int num = (int) (Math.random()*100);
        //Don't forget to add quotes around the code snippet above!
        int i = s.nextInt();

        while (i != num)
        {
            if (i < num)
            
                System.out.println("Too small, guess higher: ");
            
            else
            
                System.out.println("Too big, guess lower: ");
            
            i = s.nextInt();
        }
        s.close();
        System.out.println("Congratulations, you got it!");   

    }
}