package JavaClass4;

public class Class4Part3 {
    public static void main(String[] args) {
        //Let's get started with 2D arrays!
        /*
        String[][] food = {
            {"cereal", "burger", "pizza", "drink"},
            {"burrito, "pasta", "steak"},
            {"sandwich", "macaroni", "meatloaf"}
        };
        for (int i = 0; i < food.lengthl i++)
            for(int j = 0; j < food[i].length; j++)
                System.out.println(food[i][j]);
        */
        //This program creates a 10 by 10 array with all multiples of 5
        int[][] myArray = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                myArray[i][j] = 5*(i+1)*(j+1);
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}