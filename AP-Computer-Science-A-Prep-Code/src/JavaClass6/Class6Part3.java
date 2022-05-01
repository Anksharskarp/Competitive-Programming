package JavaClass6;

// Introduction to recursion in Java
/*
Recursion is the technique of making a function 
repeatedly call itself, thus brekaing complicated 
problems down into much simpler problems.
*/

public class Class6Part3 {
    public static void main(String[] args) {
        System.out.println(summation(100));
        System.out.println(factorial(10));
        printFun(3);
    }

    // This function adds all the numbers from the positive input
    // integer to 0 and returns their sum.
    // Essentially, this is a summation function.
    public static int summation(int k) {
        if (k > 0) {
            return k + summation(k - 1);
        } else {
            return 0;
        }
    }

    // Factorial function
    public static int factorial(int k) {
        if (k > 0) {
            return factorial(k - 1) * k;
        } else {
            return 2;
        }
    }

    static void printFun(int test) {
        if (test < 1) {
            return;
        } else {
            System.out.print(test);
            printFun(test - 1);
            System.out.print(test);
            return;
        }
    }
    //Prints 3 2 1 1 2 3
}