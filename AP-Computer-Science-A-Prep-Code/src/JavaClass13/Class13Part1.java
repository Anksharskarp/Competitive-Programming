package JavaClass13;

public class Class13Part1 {
    public static void main(String[] args) {
        String s = "This is the beginning";
        String t = s.substring(5);
        int n = t.indexOf("the");
        System.out.println(n);
        System.out.println(mystery(10));     
    }

    public static int mystery(int x) {
        if (x == 0) {
            return 0;
        } else {
            return (x + mystery(x / 2) + mystery(x / 4));
        }
    }
}