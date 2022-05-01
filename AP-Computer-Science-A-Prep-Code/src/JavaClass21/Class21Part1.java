package JavaClass21;

import java.util.*;

public class Class21Part1 {
    public static void main(String[] args) {
        String word = "hello";
        word = word + ", world!";

        int x = 3;
        int y = 4;
        String s = "I am " + x + " years old.";
        System.out.println(s);
        //Not possible, because Java doesn't convert from int to String automatically
        //String s2 = x + y;

        String sum2 = Integer.toString(x) + y;
        System.out.println(sum2);

        Date d1 = new Date(2000);
        Date d2 = new Date(2000);
        //Here, d1 is automatically converted to String
        String s2 = "My birthday is " + d1;
        System.out.println(s2);

        //The operator '+' is undefined for the '+' operator
        //String s3 = d1 + d2;
        String s4 = d1.toString() + d2;
        System.out.println(s4);

        String word1 = "HOT";
        String word2 = "HOTEL";
        String word3 = "dog";
        //compareTo method always returns the difference in position of the first unique character in two 
        //different Strings (a = 1, b = 2,..., that describes the position)
        //Both compareTo methods are case sensitive
        System.out.println(word1.compareTo(word2));
        System.out.println(word1.compareTo(word3));
        //Not case sensitive
        System.out.println(word1.compareToIgnoreCase(word3));

        //List of some commonly used String methods
        //Note that they only give information about certain parts of the String:
        //They cannot change the String itself -- they are immutable.
        /*
        int length()
        String substring(int startIndex)
        String substring(int startIndex, int endIndex)
        int indexOf(String str)
        */


    }
}