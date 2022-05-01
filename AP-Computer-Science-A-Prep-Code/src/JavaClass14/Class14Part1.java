package JavaClass14;

public class Class14Part1 {
	
    public static void main(String[] args) {
        displayLetterDiamond(20);	   
    }
    
    public static void displayLetterDiamond(int height) {
         
        for ( int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++)
                 System.out.print(" ");
                for (int j = 0; j < i; j++)
                    System.out.print((char) ('A' + j));
                for (int j = i; j >= 0; j--)
                    System.out.print((char) ('A' + j));
                
                System.out.println();
        }
 
        for ( int i = height; i >= 0; i--) {
            for (int j = 0; j < height - i; j++)
                 System.out.print(" ");
                for (int j = 0; j < i; j++)
                    System.out.print((char) ('A' + j));
                for (int j = i; j >= 0; j--)
                    System.out.print((char) ('A' + j));
                System.out.println();
        }
        
    }
}    