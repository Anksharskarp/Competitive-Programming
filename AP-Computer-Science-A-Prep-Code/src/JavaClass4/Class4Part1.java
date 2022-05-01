package JavaClass4;

//https://us04web.zoom.us/j/79548147425?pwd=NEk2TWRFeTZUNHZkRHlYd2RhQXRpdz09
//Link to rejoin temporary Zoom meeting after token expires...
public class Class4Part1 {
	public static void main(String[] args) {
        displayDiamond(9);
	}
    //This program prints a diamond of consecutive numbers
	public static void displayDiamond(int height) {
		int i, j;
		
		for ( i = 1; i<=10; i++) {
			for ( j = 1; j<=10-i; j++) 
                System.out.print(" ");
            for ( j = i; j > 1; j--)
                System.out.print(j);
			for ( j = 1; j<= i; j++) 
				System.out.print(j);
			System.out.println();
		}
		for ( i = 10; i>=1; i--) {
			for ( j = 1; j<=10-i; j++) 
                System.out.print(" ");
            for ( j = i; j > 1; j--)
                System.out.print(j);
			for ( j = 1; j<= i; j++) 
				System.out.print(j);
            System.out.println();
		}
    }
}