package intermediate.coursework.sortingalgorithms;

class BubbleSort {
    void bubbleSort(int[] arrayToSort) {
        int n = arrayToSort.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int placeholderVariable = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = placeholderVariable;
                }
            }
        }
    }

    void printArray(int[] sortedArray) {
        int n = sortedArray.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    }
}

