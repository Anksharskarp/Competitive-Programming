package JavaClass24;

public class Class24Part1 {
    public static void main(String[] args) {
        int [][] pascalTriangle = new int[20][20];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.println(pascalTriangle[i][j]);
            }
            System.out.println();
        }
    }
}