package Sorting;

import java.util.Arrays;

/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] arg) {

        int[] a = { 2, 1, 4, 0, 3 };

        bubbleSort(a);

        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] array) {

        // this logic will run for sorted array also
        // let us optimize it, if the array is sorted
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {

            swapped = false;
            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {
                    SortingUtils.swap(i, j, array);
                    swapped = true;
                }

            }

            if (!swapped) {
                break; // no swap array is already sorted;
            }
        }
    }
}