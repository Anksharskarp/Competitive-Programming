package intermediate.coursework.Class10;

public class MergeSortDemo {
    public static void main(String[] args) {

    }

    public static int merge_sort_and_inversions(int[] A, int[] TA, int beginning, int middle, int end) {
        //This is a demo of a merge sort, and this also computes the number of inversions.
        //A: an array to be sorted, TA: a working array.
        //Initial call from main program: int Inversions = merge_sort_and_inversions(A, TA, 0, (A.length-1)/2, A.length-1);
        int INT = 0;
        if(beginning == end) {
            return 0; //One element, already sorted
        }
        if(beginning < middle) {
            INT+=merge_sort_and_inversions(A, TA, beginning, (beginning + middle)/2, middle);
        }
        if(middle + 1 < end) {
            INT += merge_sort_and_inversions(A, TA, middle + 1, (middle + 1 + end) / 2, end);
        }
        //Merge two sorted subarrays into TA and then copy back to A

        int index = beginning;
        int b = beginning;
        int m = middle + 1;
        while(b < middle && m < end) {
            if(A[b] <= A[m]) {
                TA[index++] = A[b++];
            } else {
                TA[index++] = A[m++];
                INT += (middle - b + 1);
            }
        }

        while(b <= middle) {
            TA[index++] = A[b++];
        }
        while(m <= end) {
            TA[index++] = A[m++];
        }
        //Copy back to array A
        index = beginning;
        b = beginning;
        while(b <= end) {
            A[b++] = TA[index++];
        }
        return INT;
    }
}
