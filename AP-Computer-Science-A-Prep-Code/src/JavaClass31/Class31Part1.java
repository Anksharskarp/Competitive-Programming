package JavaClass31;

public class Class31Part1 {
    public static void main(String[] args) {
        System.out.println(fib(20));
    }

    //Fibonacci Sequence Function
    public static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        return (fib( n - 1) + fib(n - 2));
    }
}
