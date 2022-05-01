package JavaClass11;

public class Class11Part3 {
    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        int c = 8;
        int d = a / b;
        c /= d;
        System.out.println(c);
        //The above code will result in a run time error.
        //d ends up being zero, because of integer rounding.
    }
}