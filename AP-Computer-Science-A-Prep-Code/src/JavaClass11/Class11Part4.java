package JavaClass11;

public class Class11Part4 {
    public static void main(String[] args) {
        boolean a = true, b = false;
        if(!a && b) {
            System.out.println("Nice job.");
        } else {
            System.out.println("Nicer job.");
        }

        if(!a || b) {
            System.out.println("Nice job.");
        } else {
            System.out.println("Nicer job.");
        }

        int val1 = 2, val2 = 22, val3 = 78;
        while (val2 % val1 == 0 || val2 % 3 == 0) {
            val3++;
            val2--;
        }
        System.out.println(val3);

        for (int i = 0; i < 100; i = i * 2) {
            if (i / 50 == 0) 
                System.out.print(i + " ");
            
        }
    }
}