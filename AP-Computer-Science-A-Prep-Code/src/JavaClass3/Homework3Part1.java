package JavaClass3;

public class Homework3Part1 {
	public static void main(String[] args) {
		displayDiamond("$", 5);
		displayDiamond("#", 20);
	}

	public static void displayDiamond(String s, int height) {
		int i, j;
		
		for ( i = 1; i<=10; i++) {
			for ( j = 1; j<=10-i; j++) 
				System.out.print(" ");
			for ( j = 1; j<= i; j++) 
				System.out.print(s+s);
			System.out.println();
		}
		for ( i = 10; i>=1; i--) {
			for ( j = 1; j<=10-i; j++) 
				System.out.print(" ");
			for ( j = 1; j<= i; j++) 
				System.out.print(s+s);
			System.out.println();
		}
	}
}
	
		
       /* int count = 0; 
        while (count < 1000){
            int num = (int) (Math.random()*100);
            if (num %13 == 0)
            	continue;
            System.out.println(num);
            count++;
        }

        

		
		 Scanner s = new Scanner(System.in);
		 System.out.println("Please enter day of the week (1-7)");
		 int num = s.nextInt();
		 switch (num) {
			 case 1:
			 case 2:
			 case 3:
			 case 4:
			 case 5:
				 System.out.println("It is a weekday");
				 break;
			 case 6:
			 case 7:
				 System.out.println("It is a weekend");
				 break;
			default:
				System.out.println("Invalid input. ");
				 
			
		 }
		
		 for (int i = 1; i<=num; i++) {
			 for (int j = 1; j<=num; j++)
				 System.out.print(i*j+"\t");
			 System.out.println();
		 }
*/