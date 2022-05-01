package JavaClass31;

public class Class31Part3 {
    public static void main(String[] args) {
        System.out.println(power(4.0, 5));
        System.out.println(power(9.0, -4));
    }

    /**
     *
     * @param base a nonzero real number
     * @param expo an integer
     * @return base raised to the expo power
     */
    public static double power(double base, int expo) {
        if (expo == 0) {
            return 1;
        } else if (expo > 0) {
            return base * power(base, expo - 1);
        } else {
            return (1/base) * power(base, expo + 1);
        }
    }
}
