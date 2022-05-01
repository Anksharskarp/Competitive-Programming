package JavaClass20;

public class Homework20Part2 {
    public static void main(String[] args) {

        int max = 0;
        int num = 2;
        for (int i = 2; i <= 10000; i++) {
            int j = findPrimeFactors(i);
            if (j > max) {
                max = j;
                num = i;
            }
        }
        System.out.println(num);
        System.out.println(max);
    }

    public static int findPrimeFactors(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                if (isPrime(i))
                    count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
