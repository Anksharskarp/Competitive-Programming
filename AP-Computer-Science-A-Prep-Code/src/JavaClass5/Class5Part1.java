package JavaClass5;

public class Class5Part1 {
    public static void main(String[] args) {
        // Program prints Pascal's triangle
            printPascal(10);
    }

    public static void printPascal(int height) {
        int[][] myPascal = new int[height][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    myPascal[i][j] = 1;
                else
                    myPascal[i][j] = myPascal[i - 1][j - 1] + myPascal[i - 1][j]; // This computes the sum of the two terms directly above the bottom term.
                System.out.print(myPascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}