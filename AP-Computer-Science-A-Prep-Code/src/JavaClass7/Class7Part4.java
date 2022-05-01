package JavaClass7;

import java.util.ArrayList;

public class Class7Part4 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> common = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            /*
            We need to do type casting because Math.random module 
            returns a float
            */
            list1.add((int) (Math.random()*100)); //Don't forget to put parenthesis around Math.random!
            list2.add((int) (Math.random()*100));
        }

        System.out.println(list1);
        System.out.println(list2);

        for (int i = 0; i < 100; i++) {
            if (list2.contains(list1.get(i))) {
                common.add(list1.get(i));
            }
        }
        System.out.println(common);
    }
}