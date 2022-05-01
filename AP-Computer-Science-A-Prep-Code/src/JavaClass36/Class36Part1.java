package JavaClass36;

//Prints upside-down half-pyramid
public class Class36Part1 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            for (int j = 1; j < 10 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
