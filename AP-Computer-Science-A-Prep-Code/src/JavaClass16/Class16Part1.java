package JavaClass16;

public class Class16Part1 {
    
    public static void printPattern(char inner, char outer, int height) {
        
        //print the top of the diamond
        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < height / 2 - i; j++) {
                System.out.print(outer);
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(inner);
            }
            for (int j = 0; j < height / 2 - i; j++) {
                System.out.print(outer);
            }
            System.out.println();
        }

        //print the bottom of the diamond
        for (int i = height / 2; i >= 0; i--) {
            for (int j = 0; j < height / 2 - i; j++) {
                System.out.print(outer);
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(inner);
            }
            for (int j = 0; j < height / 2 - i; j++) {
                System.out.print(outer);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern('#', ' ', 20);
        printPattern(' ', '#', 20);
    }
}