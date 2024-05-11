package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int a[] = { 34, -2, 45, 29, 8, -10, 19 };
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    // we are adding new element to its last, and find its correct position
    // insertion sort is also called, online sort and dynamic sort
    public static void insertionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = array.length - 1; j >= 1; j--) {

                if (array[j] < array[j - 1]) {
                    SortingUtils.swap(j, j - 1, array);
                }
            }
        }
    }
}
