package array;

import java.util.Arrays;

public class AddElementToArray {

    public static void main(String[] args) {

        /**
         * Arr is of fixed size, so you always need to create a new one
         * Use an array list, it's backed by an array anyway
         * Show add() implementation
         */
        String[] arr = { "1", "2", "3" };
        arr[2] = "abc";   // works
//        arr[3] = "4"; // ArrayIndexOutOfBoundsException

        System.out.println(Arrays.toString(arr)); // prints "[1, 2, 3]"
        String[] arr2 = append(arr, "4");
        System.out.println(Arrays.toString(arr2)); // prints "[1, 2, 3, 4]"


        System.out.println(arr.length);
        System.out.println(arr2.length);

    }

    static <T> T[] append(T[] sourceArray, T newElement) {
        int origLength = sourceArray.length;
        T[] arr2 = Arrays.copyOf(sourceArray, origLength + 1);
        arr2[origLength] = newElement;
        return arr2;
    }

}

