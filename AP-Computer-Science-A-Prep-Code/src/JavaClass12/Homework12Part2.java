package JavaClass12;

public class Homework12Part2 {
    public static void main(String[] args) {
        forwardsHarmonicCalculator(50000);
        backwardsHarmonicCalculator(50000);
    }
    //Note that the sum isn't the same.
    public static void forwardsHarmonicCalculator(double n) {
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum += 1/i;
        }
        System.out.println(sum);
    }

    public static void backwardsHarmonicCalculator(double n) {
        double sum = 0;
        for (double i = n; i >= 1; i--) {
            sum += 1/i;
        }
        System.out.println(sum);
    }
}
