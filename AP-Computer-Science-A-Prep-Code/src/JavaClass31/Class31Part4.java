package JavaClass31;

public class Class31Part4 {
    public static void main(String[] args) {
        doSomething(3);
    }

    public static void doSomething(int n) {
        if (n  > 0) {
            doSomething(n - 1);
            System.out.print(n);
            doSomething(n - 1);
        }
    }
}
