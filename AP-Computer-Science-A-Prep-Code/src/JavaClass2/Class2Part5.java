package JavaClass2;

//This is a bmi calculator
// BMI = 
import java.util.Scanner;

public class Class2Part5 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        s.close();
        System.out.println("Please enter your weight(lbs):");
        System.out.println("Please enter your height(inches");
        
        double weight = s.nextDouble();
        double height = s.nextDouble();

        double bmi = 703 * weight / (height * height);
        System.out.println("Your BMI is : " + bmi);

        if (bmi < 18.5)
        {
            System.out.println("You are underweight");
        }
        else if (bmi <= 25)
        {
            System.out.println("You are normal weight");
        }
        else
        {
            System.out.println("You are overweight");
        }
    }
}