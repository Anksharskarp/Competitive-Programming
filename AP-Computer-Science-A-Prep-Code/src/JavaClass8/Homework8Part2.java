package JavaClass8;

public class Homework8Part2 {
    public static void main(String[] args) {
        convert2Decimal("101", 2);
        convert2Decimal("101", 8);
        convert2Decimal("101", 16);
    }

    public static void convert2Decimal(String num, int base) {
        int temp = Integer.valueOf(num);
        int decimalValue = 0;
        if (base == 2) {
            int binaryBase = 1;
            while (temp > 0) {
                int lastDigit = temp % 10;
                temp = temp / 10;
                decimalValue += lastDigit * binaryBase;
                binaryBase = binaryBase * 2;
            }
            System.out.println(decimalValue);
        } else if (base == 8) {
            int octalBase = 1;
            while (temp > 0) {
                int lastDigit = temp % 10;
                temp = temp / 10;
                decimalValue += lastDigit * octalBase;
                octalBase = octalBase * 8;
            }
            System.out.println(decimalValue);
        } else if (base == 16) {
            String digits = "0123456789ABCDEF"; 
            num = num.toUpperCase();  
            int val = 0;  
            for (int i = 0; i < num.length(); i++)  
             {  
                 char c = num.charAt(i);  
                 int d = digits.indexOf(c);  
                 val = 16*val + d;  
             }  
             System.out.println(val);
        }
    }
}