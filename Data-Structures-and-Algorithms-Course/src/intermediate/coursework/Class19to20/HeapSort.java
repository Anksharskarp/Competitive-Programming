package intermediate.coursework.Class19to20;

import java.util.Arrays;

//Implementation of a minimum heap (where the key value of the child is always greater than or equal to the key value
//of its parent.
//NOTE: the counterpart of the minimum heap variant of the heap data structure is the maximum heap variant, where the
//key value of the parent is always greater than other equal to the key value of its child.
public class HeapSort {
    //Checks every parent and child to see if they needed to be moved. If the key value of the child is strictly less
    //than the key value of the parent, the child and the parent swap places on the heap. Otherwise, it is ignored.
    public static void upHeap(int[] a, int i) {
        while(i > 0) {
            int p = (i - 1) / 2;
            if(a[i] < a[p]) {
                int t = a[i];
                a[i] = a[p];
                a[p] = t;
            }
            i = p;
        }
    }

    //Creates the heap data structure from the given array a, and performs an upheap operation to ensure that all the
    //elements and their respective keys match the requirements of the heap data structure.
    public static void buildHeap(int[] a) {
        for(int i = 1; i < a.length; i++) {
            upHeap(a, i);
            //System.out.println(Arrays.toString(a));
        }
    }


    public static void downHeap(int[] a, int size) {
        int i = 0;
        while(2 * i + 1 < size) {
            int smallIndex = 2 * i + 1;
            if(2 * i + 2 < size) { //Checks to see if it has a right child.
                if(a[2 * i + 1] > a[2 * i + 2]) {
                    smallIndex = 2 * i + 2;
                }
            }
            if(a[i] <= a[smallIndex]) {
                break;
            }
            int t = a[i];
            a[i] = a[smallIndex];
            a[smallIndex] = t;
            i = smallIndex;
        }
    }

    public static void removeMin(int[] a, int size) {
        int min = a[0];
        a[0] = a[size - 1];
        a[size - 1] = min;
        downHeap(a, size - 1);
    }

    public static void heapSort(int[] a) {
        buildHeap(a);
        System.out.println(Arrays.toString(a));

        int size = a.length;
        for(int i = a.length - 1; i >= 0; i--) {
            removeMin(a, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 3, 2, 6, 4, 9, 7, 1, 8, 5};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(a));
        System.out.println();
        heapSort(a);
        System.out.println();
        System.out.println("Result of Heapsort on Array:");
        System.out.println(Arrays.toString(a));
        System.out.println();
    }
}
