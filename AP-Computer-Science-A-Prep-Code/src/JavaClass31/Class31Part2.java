package JavaClass31;

public class Class31Part2 {
    public static void main(String[] args) {
        reverseDigits(6853971);
    }

    //Program that reverses the digits of the integer input
    public static void reverseDigits(int n) {
        if ( n <= 9) {
            System.out.print(n);
        } else {
            System.out.print(n % 10);
            reverseDigits(n / 10); //Note that in Java, integers are rounded off
            //like: 768 / 10 = 76
        }
    }
}
