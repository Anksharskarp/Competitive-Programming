package JavaClass37;

public class Class37Part1 {
    public static void main(String[] args) {
        System.out.println(findMissingChar("abdef"));
        System.out.println(findMissingChar("OPRST"));
    }

    private static char findMissingChar(String s) {
        //int n = (int) (s.charAt(0));

        for(int i = 0; i < s .length() - 1; i++) {
            int c1 = s.charAt(i);
            int c2 = s.charAt(i + 1);
            if((c2 - c1) != 1) {
                return (char) (c1 + 1);
            }
        }

        return ' ';
    }
}
