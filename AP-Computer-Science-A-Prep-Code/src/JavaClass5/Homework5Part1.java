package JavaClass5;

import java.lang.Math;

public class Homework5Part1 {
    public static void main(String[] args) {
        int[][] exponentialTable = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {2, 4, 8, 16, 32, 64, 128, 256},
            {3, 9, 27, 81, 243, 729, 2187, 6561},
            {4, 16, 64, 256, 1024, 4096, 16384, 65536},
            {5, 25, 125, 625, 3125, 15625, 78125, 390625},
            {6, 26, 215, 1296, 7776, 46656, 279936, 1679616},
            {7, 49, 343, 2401, 16807, 117649, 823543, 5764801},
            {8, 64, 512, 4096, 32768, 262144, 2097152, 16777216}
        };
        
        System.out.println("Exponential Table, printed two different ways: ");

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                System.out.print(Math.round(Math.pow(i, j)) + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(exponentialTable[i][j]);
            }
            System.out.println();
        }
    }
}