package JavaClass13;

/*
Find all numbers with between 1 and 10,000 with the following feature:
the sum of the cubes of its digits is equal to the number itself.
*/

public class Class13Part2 {
    public static void main(String[] args) {
        numberChecker();
    }

    public static void numberChecker() {
        int i = 1;
        while(i <= 10000) {
            if (check(i)) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static boolean check(int i) {
        int sum = 0;
        int digit, temp = i;
        //The modulo 10 cycles through every single digit
        while(temp > 0) {
            digit = temp % 10;
            sum += digit * digit * digit;
            temp = temp / 10;
        }
        return i == sum;
    }
}
