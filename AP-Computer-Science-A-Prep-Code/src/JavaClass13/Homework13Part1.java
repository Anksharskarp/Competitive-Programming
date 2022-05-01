package JavaClass13;

public class Homework13Part1 {
    public static void main(String[] args) {
        //Looks for the narcissistic numbers up to 10,000
        narcissistic(10000);
    }

    public static void narcissistic(int n) {
        int i = 1;
        while(i <= n) {
            if (check(i)) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static boolean check(int i) {
        int sum = 0;
        int digit, temp = i;
        int length = countDigit(i);
        //The modulo 10 cycles through every single digit
        while(temp > 0) {
            //Single digit value increment
            digit = temp % 10;
            /*Note the Math.pow(double base, double exponent); will only accept double as input,
            so we need to type cast from int to double, then back to int, because the sum that 
            we get needs to be of type int.
            */
            sum += (int) Math.pow(digit, length);
            //Moving on to the next digit
            temp = temp / 10;
        }
        //Is the sum equal to the number value itself?
        return i == sum;
    }

    //Useful code snippet. Count number of digits in int.
    public static int countDigit(int n) 
    { 
        int count = 0; 
        while (n != 0) { 
            n = n / 10; 
            ++count; 
        } 
        return count; 
    }
}