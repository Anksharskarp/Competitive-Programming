package JavaClass17;

public class Class17Part1 {
    public static Class17Part1 someMethod(Class17Part1 obj) {
        //ans is just a reference data type, so it just points
        //to obj. It doesn't have its own memory slot.
        Class17Part1 ans = obj;
        return ans;
    }

    Class17Part1(int n) {
    }

    public static void main(String[] args) {
        Class17Part1 x = new Class17Part1(2);
        Class17Part1 y = new Class17Part1(7);
        Class17Part1 a = y;
        System.out.println(a);
        x = someMethod(y);
        a = someMethod(x);
    }
}
