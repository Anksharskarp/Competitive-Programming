//SUCCESS
import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n > 2) {
            if (n % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}
