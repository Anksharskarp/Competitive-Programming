package JavaClass38;

import java.util.Scanner;

public class Class38Part1 {
    public static void main(String[] args) {

        System.out.println("3 Jugs: 3, 5, 8 liters, get an exact measure of 4 liters");
        int[] volume = {0, 0, 8}; //amount of milk in each jug
        int[] capacity = {3, 5, 8}; //capacity of each jug
        String statement = "\"1: \" + volume[0] + \" 2: \" + volume[1] + \" 3: \" + volume[2]";

        while(volume[0] != 4 && volume[1] != 4 && volume[2] != 4) {
            try {
                System.out.println(statement);
                System.out.println("Which jug would you like to pour from (1-3)");
                Scanner s = new Scanner(System.in);
                int fromJug = s.nextInt() - 1;
                System.out.println("Which jug would you like to pour into (1-3)");
                int intoJug = s.nextInt() - 1;

                int fromJugAmount = volume[fromJug];
                int intoJugSpace = capacity[intoJug] - volume[intoJug];

                if (fromJugAmount >= intoJugSpace) {
                    volume[intoJug] = capacity[intoJug];
                    volume[fromJug] -= intoJugSpace;
                } else {
                    volume[fromJug] = 0;
                    volume[intoJug] += fromJugAmount;
                }
            } catch(Exception e) {
                System.out.println("Please enter valid input (integers 1 to 3).");
            }
        }
        System.out.println("Congratulations, you made it!");
        System.out.println(statement);
    }
}
