package JavaClass10;

import java.util.Arrays;

public class Homework10Part2 {

    static void uniqueArray(int[] myArray) {
        System.out.println("Original array: ");

        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + "\t");
        }

        int noUniqueElements = myArray.length;
        
        for (int i = 0; i < noUniqueElements; i++) {
            for (int j = i + 1; j < noUniqueElements; j++) {
                if (myArray[i] == myArray[j]) {
                    myArray[j] = myArray[noUniqueElements - 1];
                    noUniqueElements--;
                    j--;
                }
            }
        }

        int[] array1 = Arrays.copyOf(myArray, noUniqueElements);
        System.out.println();
        System.out.println("Array with unique values: ");

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }

        System.out.println();
        System.out.println("---------------------------");
    }
    public static void main(String[] args) {
        uniqueArray(new int[] {4, 5, 6, 6, -3, 0});
        uniqueArray(new int[] {45, -45, 3, 3, 3, 1});
    }
}