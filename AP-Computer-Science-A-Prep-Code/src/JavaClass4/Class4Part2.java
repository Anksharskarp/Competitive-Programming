package JavaClass4;

public class Class4Part2 {
    public static void main(String[] args) {
        String[] food = {"pizza", "ice cream", "burgers", "sub sandwich"};
        System.out.println(food.length); //prints 4
        
        for (int i = 0; i < food.length; i++) {
            System.out.println(food[i]);
        }

        for (String f:food) {
            System.out.println(f);
        }
        /*
        food[4] = "fries";
        food[5] = "soda";
        */
        //This program creates an array of 100 random integers
        //(between 1 - 1000) and finds the average.
        int[] numbers = new int[100];
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            numbers[i] = (int) (Math.random()*1000); //Don't forget to put parenthesis around Math.random()*1000
            System.out.println(numbers[i]);
            sum += numbers[i];
        }
        System.out.println("The average of the numbers is: " + sum / numbers.length);

    }
}