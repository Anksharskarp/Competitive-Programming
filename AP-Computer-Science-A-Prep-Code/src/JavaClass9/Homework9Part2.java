package JavaClass9;

import java.util.Scanner;

public class Homework9Part2 {
    public static void main(String[] args) {
        int decimalNumber;
        int quotient;
        int i = 1;
        int j;
        int[] binaryNumber = new int[100];
        Scanner s = new Scanner(System.in);

        System.out.println("Input a Decimal Number");
        decimalNumber = s.nextInt();
        s.close();

        quotient = decimalNumber;

        while(quotient != 0) {
            binaryNumber[i++] = quotient % 2;
            quotient /= 2;
        }
        String binaryString = "";
        for(j = i - 1; j > 0; j--) {
            binaryString += binaryNumber[j];
        }
        System.out.println("The binary number is: " + binaryString);
        
        long N = Integer.parseInt(binaryString);
        long maxm = -1;   
        int cnt = 0;  
        
        while (N != 0) {  
            if ((N & 1) == 0 ) {  
                cnt++;  
                N >>= 1;  
                maxm = Math.max(maxm, cnt);  
            }  
            else {  
        
                maxm = Math.max(maxm, cnt);  
                cnt = 0;  
                N >>= 1;  
            }  
        }  
        System.out.println(maxm);
        
    }   
}