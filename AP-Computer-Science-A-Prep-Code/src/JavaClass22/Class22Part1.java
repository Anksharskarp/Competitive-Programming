package JavaClass22;

public class Class22Part1 {
    public static void main(String[] args) {
        /*
        ALL ABOUT WRAPPER CLASSES
        Only for wrapper classes can you use:
        -Integer
        -compareTo()
        -.equals() method
        */
        Integer intObj = new Integer(6);
        int j = intObj.intValue();
        Object object = new Integer(5);
        Integer intObj2 = new Integer(3);
        int k = intObj2.intValue();

        System.out.println(j);
        System.out.println(k);

        System.out.println(intObj.equals(intObj2));
        System.out.println(intObj.intValue() == intObj2.intValue());
        //Error: System.out.println(k.equals(j));
        //Error: System.out.println((intObj.intValue()).compareTo(intObj2.intValue()) < 0);
        //Error: System.out.println(intObj.compareTo(object) < 0);
        System.out.println(intObj.compareTo((Integer) object));
        System.out.println(intObj.compareTo((Integer) object) < 0);
        //Error: System.out.println(object.compareTo(intObj) < 0);
        System.out.println(((Integer) object).compareTo(intObj) < 0);
        System.out.println(((Integer) object).compareTo(intObj) < 0);

    }
}
