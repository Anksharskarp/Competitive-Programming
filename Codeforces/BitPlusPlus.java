//SUCCESS
import java.util.Scanner;

public class BitPlusPlus {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfInputs = s.nextInt();
        int x = 0;
        String a = "X++";
        String b = "++X";
        String[] expressions = new String[numberOfInputs];
        for(int i = 0; i < numberOfInputs; i++)  {
            String y = s.next();
            expressions[i] = y;
        }
        for(int i = 0; i < numberOfInputs; i++) {
            if(expressions[i].equals(a) || expressions[i].equals(b)) {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(x);
    }
}