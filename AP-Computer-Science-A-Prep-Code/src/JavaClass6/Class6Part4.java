package JavaClass6;

public class Class6Part4 {
    public static void main(String[] args) {
        fun(25);
    }

    // Converts number to binary form, but backwards
    static void fun(int n) {
        if (n == 0)
            return;
        
        System.out.println(n%2);
        fun(n/2);        
    }
}