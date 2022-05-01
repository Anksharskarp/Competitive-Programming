package JavaClass6;

public class Homework6Part2 {

    static void pairsValue(int[] inputArray, int sumNumber) {
        System.out.println("Calculating the pairs of numbers that add up to the sum...");
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == sumNumber) {
                    System.out.println(inputArray[i] + " + " + inputArray[j] + " = " + sumNumber);
                }
            }
        }
    }
    public static void main(String[] args) {
        pairsValue(new int[] {2, 7, 4, -5, 11, 5, 8, 20}, 15);
    }
}