package JavaClass9;

public class Class9Part1 {
    public static void main(String[] args) {
        print("Hello, world!");
        int n = 7;
        if (n > 0)
	        if (n % 2 == 0)
		        System.out.println(n);
        else
	        System.out.println(n + " is not positive");
    } // The above block of code prints
    // 7 is not positive

    public static void print(String word) {
        System.out.println(word);
    }
}