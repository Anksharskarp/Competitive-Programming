//SUCCESS
import java.util.ArrayList;
import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int amount = s.nextInt();
        ArrayList<String> strings = new ArrayList<String>();
        while(amount >= 0) {
            strings.add(s.nextLine());
            amount--;
        }
        String input;
        for(int i = 0; i < strings.size(); i++) {
            input = strings.get(i);
            if (input.length() > 10) {
                System.out.println(Character.toString(input.charAt(0)) + (input.length() - 2) +
                        input.charAt(input.length() - 1));
            } else {
                System.out.println(input);
            }
        }
    }
}
