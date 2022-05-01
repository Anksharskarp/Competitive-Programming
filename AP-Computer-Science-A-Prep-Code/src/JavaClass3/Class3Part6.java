package JavaClass3;

public class Class3Part6 {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;
        while (count < 1000) {
            num = (int) (Math.random()*100);
            if (num % 13 == 0)
                continue;
            System.out.println(num);
            count ++;
        }
        
        
    }
}