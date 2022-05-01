package JavaClass22;

//Java program that removes duplicates char in String
public class Homework22Part1 {
    public static void main(String[] args) {
        String s = "hellollo";
        unrepeated(s);
    }

    public static void unrepeated(String string) {
        String result = "";

        for (int i = 0; i < string.length(); i++) {
            if (!result.contains(string.substring(i, i + 1))) {
                result = result + string.charAt(i);
            }
        }
        System.out.println(result);
    }
}