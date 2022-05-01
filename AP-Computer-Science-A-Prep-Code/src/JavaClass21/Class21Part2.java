package JavaClass21;

import java.util.*;

public class Class21Part2 {
    public static void main(String[] args) {

        int[] arr = {5, 4, 1, 6, 3, 2};
        System.out.println(checkArray(arr));

        int[] arr2 = {7, 5, 3, 2};
        System.out.println(checkArray(arr2));

        int[] arr3 = {3, 2, 1, 5, 4, 6, 6};
        System.out.println(checkArray(arr3));

        int[] arr4 = new int[10];
        for(int i = 0; i < 10; i++) 
            arr4[i] = (int) (Math.random() * 10);
        System.out.println(Arrays.toString(arr4));
        System.out.println(checkArray(arr4));
    }

    //Function checks whether elements in an array can be rearanged to form a consecutive list of numbers
    //where each number appears exactly once.
    public static boolean checkArray(int[] arr) {
        Arrays.sort(arr);

        int length = arr.length;
        //Checks if it is consecutive
        for(int i = 1; i < length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }
}