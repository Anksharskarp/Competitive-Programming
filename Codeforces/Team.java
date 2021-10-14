//SUCCESS
import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfProblems = s.nextInt();
        int a;
        int b;
        int c;
        int numberImplemented = 0;
        int placeHolder;
        for(int i = 0; i < numberOfProblems; i++) {
            a = s.nextInt();
            b = s.nextInt();
            c = s.nextInt();
            placeHolder = a + b + c;
            if(placeHolder >= 2) {
                numberImplemented++;
            }
            placeHolder = 0;
        }
        System.out.println(numberImplemented);
    }
}
