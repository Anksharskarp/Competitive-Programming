package JavaClass8;

public class Class8Part1 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(-Math.pow(2, 31));

        /* In java,
        - Double divided by integer results in double
        - integer divided by integer results in double
        - integer divided integer results in integer(rounded down)
        - type casting automatically keeps the integer part (if casted to type int)
        - type casting to double keeps the precision ad adds decimal point to the end of an integer
        */
    }
}