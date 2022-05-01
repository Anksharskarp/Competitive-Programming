package JavaClass8;

public class Class8Part2 {
    public static void main(String[] args) {
        int i = 234567;
        convert(i, 2);
        convert(i, 8);
        convert(i, 16);
    }

    // Converts decimal number to base 2, 8, or 16
    public static void convert(int num, int base) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String convertedNumber = "";
        int n = num;
        while (n > 0) {
            int d = n % base;
            n = n / base;
            convertedNumber = digits[d] + convertedNumber;
        }
        System.out.println(convertedNumber);
    }   
}