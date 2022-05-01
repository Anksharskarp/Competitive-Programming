package JavaClass3;

public class Class3Part1 {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        int z = 2;

        System.out.println((x == y) || (x != y)); //true
        System.out.println((x >= y) && (x > y)); //true
        System.out.println((x > y) || (x > y)); //true
        System.out.println((x > y*z) || (x > y % z)); //true
    }
}