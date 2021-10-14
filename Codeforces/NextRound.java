//SUCCESS
import java.util.ArrayList;
import java.util.Scanner;

public class NextRound {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfParticipants = s.nextInt();
        int baseline = s.nextInt();
        int numberAdvancing = 0;
        ArrayList<Integer> scores = new ArrayList<>();
        for(int i = 0; i < numberOfParticipants; i++) {
            scores.add(s.nextInt());
        }
        int minimumScore = scores.get(baseline - 1);
        for(int element : scores) {
            if((element >= minimumScore) && (element > 0)) {
                numberAdvancing++;
            }
        }
        System.out.println(numberAdvancing);

    }
}
