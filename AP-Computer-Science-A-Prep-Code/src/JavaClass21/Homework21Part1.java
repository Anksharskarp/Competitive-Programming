package JavaClass21;

import java.util.Arrays;

public class Homework21Part1 {

    public static void main(String[] args) {

        int[] a1 = new int[10];
        int[] a2 = new int[10];

        for (int i = 0 ; i<10; i++) {
            a1[i] = (int) (Math.random()*10);
            a2[i] = (int) (Math.random()*10);
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

        System.out.println(uniqueNum(a1));
        System.out.println(uniqueNum(a2));

        System.out.println(uniqueNum(a1) == uniqueNum(a2));
    }

    public static int uniqueNum(int[] arr) {
        return (int)Arrays.stream(arr).distinct().count();
    }

}
