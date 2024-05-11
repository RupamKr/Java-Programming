package Sorting;

import java.util.Arrays;

/**
 * SelectionSort
 */
public class SelectionSort {

    public static void main(String[] arg) {

        int a[] = { 34, -2, 45, 29, 8, -10, 19 };
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    //we start with 0th index, for 0th index which element will be right to place,
    //ans is the smallest one, we do learner search and find the smallest one, and then swap it with 0th index where it found
    public static void selectionSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            int index = i;

            for (int j = i + 1; j < a.length; j++) {

                if (a[j] < a[index]) {
                    index = j;
                }
            }

            SortingUtils.swap(i, index, a);
        }

    }
}