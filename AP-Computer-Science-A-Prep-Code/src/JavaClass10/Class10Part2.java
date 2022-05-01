package JavaClass10;

public class Class10Part2 {
    public static void main(String[] args) {
        /*Examples of exceptions:
        ArithmeticException occurs when you divide by 0
        NullPointerException occurs when you use x.a, but x is null
        ClassCastException occurs when you attempt to cast from one object to another but cannot
        IllegalArgumentException occurs when you argument to a program does fit its parameters
        */
        // An unchecked exception is one where you don't provide code to deal with the error
        // A checked exception is one where you provide code to handle the exception, either a try/catch/finally statement, or an explicit throw new ...Exception clause.

        System.out.println("\\*This is not\n a comment*\\");
    }

    int radius;
    public void setRadius(int newRadius) {
        if (newRadius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        } else {
            radius = newRadius;
        }
    }
}