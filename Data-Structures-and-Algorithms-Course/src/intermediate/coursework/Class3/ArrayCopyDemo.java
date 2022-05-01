package intermediate.coursework.Class3;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] data = {5, 2, 3, 1, 10};

        System.out.println("Elements in the original (unmodified) array: ");
        for(int element : data) {
            System.out.print(element + " ");
        }
        System.out.println();

        //This only maps all the element of "data" to "shallowBackup," merely creating a new alias for the original
        //array at the same memory address as the original!
        int[] shallowBackup = data;
        //This completely copies all the elements of "data" to "deepBackup," creating two separate arrays!
        int[] deepBackup = data.clone();
        data[0] = 9;

        System.out.println("Elements in the original (modified) array: ");
        for(int element : data) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("Elements in the shallow backup array (should be the same as the edited original): ");
        for(int element : shallowBackup) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("Elements in the deep backup array (should be the same as the unedited original): ");
        for(int element : deepBackup) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}