package intermediate.coursework.dynamicprogramming;

/*
Dynamic Programming Algorithms:
In dynamic programming, a large and complicated problem is broken down into smaller sub-problems in a recursive manner
until the smallest problem size is reached. From there on out, the solutions are combined in an upward manner to get
a more sophisticated solution until at the root of the "solution tree," the final solution is obtained by the algorithm.
 */
public class DynamicProgrammingExplorations {
    //Example case of recursive calls on a dynamic programming operation that breaks down a problem into smaller parts.
    static int count = 0;

    public static void main(String[] args) {
        count = 0;
        int N = 10;
        System.out.println("Top-down recursive function demonstration (with no cache):");
        int fn = recursiveFunction(N);
        System.out.println(fn + " with " + count + " recursive calls. Beginning new calculation...");

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = -1;
        }
        count = 0;
        fn = dynamicProgrammingRecursionWithMemorization(N, dp);
        System.out.println(fn + " with " + count + " recursive calls. Starting another calculation...");

        count = 0;
        fn = dynamicProgrammingBottomUp(N, dp);
        System.out.println("End of all recursive dynamic programming calculations.");

    }

    /*
    An implementation of a Matrix-chain Multiplication Algorithm using the foundational principles of dynamic
    programming. Here, we are trying to multiply multiple matrices together, using the standard mathematical method
    of chaining rows (1st matrix in the matrix multiplication process) and columns (2nd matrix in the matrix
    multiplication process) together for their elements to be multiplied together one by one, then summed together
    to give the final product of multiplying the singular row and column together, which is then added to the product
    matrix as an element.
     */
    public static long[] matrixChainMultiplication(int[] P, int beginningIndex, int endingIndex) {

        return null;
    }

    //Top-down algorithm (with base case that it constantly returns to, resulting in the original calculations
    //having to constantly be repeated with every iteration.
    /*
    Time Complexity: O(2^n), pure recursive operation
    The main problems are that when you're breaking down f(n) into f(n - 1) and f(n - 2), it is possible that
    any subsets of the functions, for example f(n - 3) or f(n - 4), or the aforementioned functions themselves,
    may be repeatedly calculated in the operations. Without a "cache," the same functions are run and calculated
    over and over again, pushing up the time complexity of this through the roof (2^n due to it being a binary tree
    sample).
     */
    public static int recursiveFunction(int n) {
        //Note that this functional is totally recursive, with the sample subproblem being repeatedly computed
        count++;
        System.out.println("n = " + n + "  count = " + count);

        if (n == 1 || n == 2) {
            return n;
        }

        return recursiveFunction(n - 1) + recursiveFunction(n - 2);
    }

    //The top-down dynamic programming version with a cache (memorization) is exceedingly efficient.
    /*
    Time Complexity: O(n), possibly 30n
    Space Complexity: O(LARGE NUMBER), due to the recursive calls making the stack large
     */
    public static int dynamicProgrammingRecursionWithMemorization(int n, int[] dp) {
        count++;
        System.out.println("n = " + n + "    count = " + count);

        if (dp[n] != -1) {
            System.out.println("Return without recursive call!");
            return dp[n];
        }

        if (n <= 2) {
            dp[n] = n;
            return dp[n];
        }

        dp[n] = dynamicProgrammingRecursionWithMemorization(n - 1, dp) + dynamicProgrammingRecursionWithMemorization(n - 2, dp);
        return dp[n];
    }

    //Dynamic programming with the problem breakdown, but no recursion (simpler/faster).
    /*
    Time Complexity: O(n), possibly 2n
    Space Complexity: O(n)
     */
    public static int dynamicProgrammingBottomUp(int n, int[] dp) {
        count++;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
