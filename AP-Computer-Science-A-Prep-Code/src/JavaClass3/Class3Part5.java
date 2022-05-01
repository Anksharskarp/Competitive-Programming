package JavaClass3;

public class Class3Part5 {
    public static void main(String[] args) {
        /* The continue statement breaks one iteration
        (in the loop), if a specified conditions occurs,
        and continues with the next iteration in the loop.
        */
        //Below code does the 'do' method as long as the while
        // statement is satisfied...
        int i = 0;
        do {
            System.out.println(i);
            i++;
        }
        while (i < 500);

        int num = 0;
        while (true) {
            num = (int) (Math.random()*100);
            System.out.println(num);
            if (num == 13)
                break;
        }
         
    }
}