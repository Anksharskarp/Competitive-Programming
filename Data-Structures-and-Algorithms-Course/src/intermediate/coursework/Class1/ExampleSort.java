package intermediate.coursework.Class1;

public class ExampleSort {
    static void display(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

        public static void sort(int[] A) {
            for(int i = 0; i < A.length - 1; i++) {
                int ind = i;
                for(int j = i + 1; j < A.length; j++) {
                    if(A[ind] > A[j]) {
                        ind = j;
                    }
                }
                int t = A[i];
                A[i] = A[ind];
                A[ind] = t;
            }
        }

    public static void main(String[] args) {
        //keep this function call here
        int[] A = {10, 4, 1, 9, 3, 7, 8, 2, 6, 5};
        sort(A);
        display(A);
    }
}
