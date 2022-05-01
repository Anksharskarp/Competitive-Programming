package JavaClass1;

import java.util.Scanner;

class Class1Part4 {
    public static void main(final String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the height of the pyramid: ");
        int height = s.nextInt();
        s.close();

        for (int i = 0; i < height; i++){
            for (int j = 0; j < height -i; j++)
                System.out.print(" ");
            for (int j = 0; j < i; j++)
                System.out.print("**");
            System.out.println();
        }
     }
}          