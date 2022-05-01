package JavaClass39;

import java.util.Arrays;

public class Class39Part2 {
    public static void main(String[] args) {
        int[] intList = new int[5];
        System.out.println(Arrays.toString(intList));

        for(int a : intList) {
            a = a + 1;
        }
        System.out.println(Arrays.toString(intList));

        for(int i = 0; i < intList.length; i++) {
            intList[i] += 1;
        }
        System.out.println(Arrays.toString(intList));
    }
}
