package Sorting;

import java.util.Arrays;

import DateAndTimeUtils.TimeUtils;

/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] arg) {

        int[] a = new int[100000];
        long startTime = TimeUtils.getTimeInSeconds();
        for (int i = 0; i < a.length; i++) {
            a[i] = SortingUtils.generateRandomNumber(10000);
        }

        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        TimeUtils.printTotalTimeTaken(startTime);
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