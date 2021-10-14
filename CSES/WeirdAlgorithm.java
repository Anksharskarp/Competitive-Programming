//SUCCESS
import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        weirdAlgorithm(n);
    }

    public static void weirdAlgorithm(long number) {
        System.out.print(number + " ");
        while(number != 1) {
            if(number % 2 == 0) {
                number /= 2;
            } else {
                number *= 3;
                number++;
            }
            System.out.print(number + " ");
        }
    }

}
