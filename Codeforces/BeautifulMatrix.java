//SUCCESS
import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] matrix = new char[5][5];
        for (int i = 0; i < 5; i++)
            matrix[i] = s.nextLine().replaceAll(" ", "").toCharArray();
        int row = -1;
        int column = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == '1') {
                    row = i;
                    column = j;
                    break;
                }
            }
        }
        int numberOfMoves = Math.abs(row - 2) + Math.abs(column - 2);
        System.out.println(numberOfMoves);
    }
}
