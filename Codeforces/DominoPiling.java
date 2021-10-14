//SUCCESS
import java.util.Scanner;

public class DominoPiling {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int area = m * n;
        if(area % 2 == 0) {
            System.out.println(area / 2);
        } else {
            System.out.println((area - 1) / 2);
        }
    }
}
