package JavaClass37;

/*
Question:
Write the ArrayUtil method reverseArray. For example, if arr is the array
{2,7,5,1,0}, the call to reverseArray changes arr to be {0,1,5,7,2}.
Complete method reverseArray below.
 */

//Other methods are not shown.
public class ArrayUtil {
    /**
     * Reverses elements of array arr.
     * Precondition: arr.length > 0.
     * Postcondition: The elements of arr have been reversed.
     *
     * @param arr the array to manipulate
     * Part (a.)
     */
    public static void reverseArray(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            //Switch arr[i] and arr[arr.length - 1 - i]
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

}


