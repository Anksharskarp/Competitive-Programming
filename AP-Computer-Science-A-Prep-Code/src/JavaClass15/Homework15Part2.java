package JavaClass15;

import java.util.Arrays;
import java.util.Scanner;

/*
This program checks if two strings are permutations of each other
*/
class Homework15Part2 { 
  
    public static boolean arePermutation(String str1, String str2) {  
        //Get the length
        int n1 = str1.length();  
        int n2 = str2.length();    
        if (n1 != n2)  
        return false;  
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
    
        // Sort both strings as array of characters
        Arrays.sort(ch1);  
        Arrays.sort(ch2);  
    
        // Compare sorted strings to see if they are the same
        for (int i = 0; i < n1; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }      
    
        return true;  
    }
    //Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter the first string");
        String str1 = s.nextLine();
        System.out.println("Please enter the second string");
        String str2 = s.nextLine();  
        if (arePermutation(str1, str2)) {
            System.out.println("Yes");  
        } else {
            System.out.println("No");  
        }
        s.close();
    } 
}  
