package JavaClass7;

import java.util.ArrayList;

public class Homework7Part2 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("The");
        list1.add("quick");
        list1.add("fox");
        list1.add("jumps");
        list1.add("over");
        list1.add("the");
        list1.add("lazy");
        list1.add("dog");

        addStars(list1);
        System.out.println(list1);
        removeStars(list1);
        System.out.println(list1);
    }

    public static void addStars(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.add(i, "*");
        }
        System.out.println(list);
    }

    public static void removeStars(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);
    }
}