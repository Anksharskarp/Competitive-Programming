package JavaClass33;

public class Class33Part1 {
    /*
    An example of the insertion sort algorithm
     */
    public static int[] insertionSort(int[] a) {
        for(int i = 1; i < a.length; i++) {
            Integer temp = a[i];
            int j = i - 1;
            while (j > 0 && temp.compareTo(a[j]) > 0) {

                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
        //TODO make this return something
        return a;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 6, 2, 7, 8, 10};
        int[] arr2 = {4, 4, 5, 2, 1, 7, 9};
        int[] arr3 = {10, 9, 4, 3, 2, 1};

        insertionSort(arr1);
        insertionSort(arr2);
        insertionSort(arr3);

        for (int j : arr1) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();
        for (int j : arr2) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();
        for (int j : arr3) {
            System.out.print(j);
            System.out.print(" ");
        }
    }
}
