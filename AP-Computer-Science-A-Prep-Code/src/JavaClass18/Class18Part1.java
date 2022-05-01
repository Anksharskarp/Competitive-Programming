package JavaClass18;

import java.util.ArrayList;

public class Class18Part1 {
    public static void main(String[] args) {
        System.out.println();
        for(int i = 1; i <= 10000; i++) {
            if (checkInt(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean checkInt(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }        
        }

        int sum = 0;
        for(int d : divisors)
            sum += d;

        return sum == n;
    }
}