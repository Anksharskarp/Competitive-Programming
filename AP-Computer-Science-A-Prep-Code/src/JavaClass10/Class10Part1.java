package JavaClass10;

import java.util.ArrayList;

public class Class10Part1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            list.add(10 * i);
        }
        //list: [10, 20, 30, ..., 100]
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        /* 
        1st pass: [20, 30, 40, ..., 100] removed 0
        2nd pass: [20, 40, 50, ..., 100] removed 1
        3rd pass: [20, 40, 60, 70, ..., 100] removed 2
        4th pass: [20, 40, 60, 80, 90, 100] removed 3
        5th pass: [20, 40, 60, 80, 100] removed 4
        Exits loop because we are at the end of the list
        */
        System.out.println(list);

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            list1.add(2 * i);
        }
        //list: [2, 4, 6, 8, 10]
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list1.add(i, 42);
        }
        // list: [42, 42, 42, 42, 42, 2, 4, 6, 8, 10]
        System.out.println(list1);

        for (int k = 0; k < 20; k = k + 2) {
            if (k % 3 == 1) {
                System.out.print(k + "  ");
            }
        }
        // Prints: 4  10  16
    }
}