package JavaClass39;

public class Class39Part1 {
    public static void main(String[] args) {
        System.out.println(numPathInGrids(2));
        System.out.println(numPathInGrids(3));
        System.out.println(numPathInGrids(10));
    }

    public static long numPathInGrids(int n) {
        /* Returns the number of paths that one can take
           to travel from one corner of the square grid
           to the opposite corner.

           Number of Paths = (2n)(2n - 1)(2n - 2)....(n + 1)/(1 * 2 * 3....n)!
                           = (2n)!/(n! * n!)
         */

        long num = 1;
        for(int i = 2 * n; i >= n + 1; i--) {
            num *= i;
        }

        for(int i = 1; i <= n; i++) {
            num /= i;
        }

        return num;

    }
}