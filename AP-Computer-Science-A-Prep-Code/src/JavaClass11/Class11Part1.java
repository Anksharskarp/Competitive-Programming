package JavaClass11;

public class Class11Part1 {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.1 + 0.1);
        //The above code prints a long decimal followed by a 4
        System.out.println(0.3== (0.1+0.1+0.1));

        //The code below doesn't work, because we cannot add a double and an int
        /*
        int a = 10;
        double b = 10.7;
        double c = a + b;
        int d = a + c;  
        System.out.println(c + "" + d);
        */
        int a = 10;
        double b = 10.7;
        double c = a + b;
        int d = (int) (a + c);  
        System.out.println(c + " " + d);
    }
}