package JavaClass7;

import java.util.ArrayList;

public class Class7Part3 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(10); //Adds the value 10 to the arraylist
        scores.add(20);
        scores.add(30);
        scores.add(1);
        scores.add(2);

        scores.remove(1); //Removes the value at index 1, which is 20
        scores.remove(2); //Java uses zero list indexing
        //scores.remove(new Integer(1)); Removes all integers 1

        scores.get(0);
        scores.get(1);
        scores.get(scores.size() - 1); //size is a function
        // scores.get(scores.length - 1); length is not a function

        System.out.println("Modified ArrayList: " + scores);
    }
}