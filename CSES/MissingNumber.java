//FAILURE
import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long numberOfValues = s.nextLong();
        long[] a = new long[(int) numberOfValues];
        for(int i = 0; i < a.length; i++) {
            a[i] = s.nextLong();
        }

        Arrays.sort(a);

        long[] total = new long[(int) (numberOfValues + 1)];
        Arrays.parallelSetAll(total, i -> i + 1);

        for(int i = 0; i < total.length; i++) {
            total[i] += (a[0] - 1);
        }

        for(int i = 0; i < a.length; i++) {
            if(a[i] == total[i]) {
                continue;
            } else {
                System.out.println(total[i]);
                break;
            }
        }
    }
}
