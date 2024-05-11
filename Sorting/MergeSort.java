package Sorting;

import java.util.Arrays;

import DateAndTimeUtils.TimeUtils;

/**
 * MergeSort
 */
public class MergeSort {

    public static void main(String[] args) {

        int a[] = new int[100000];
        long startTime = TimeUtils.getTimeInSeconds();
        for (int i = 0; i < a.length; i++) {
            a[i] = SortingUtils.generateRandomNumber(10000);
        }

        mergeSort(a);
        System.out.println(Arrays.toString(a));
        TimeUtils.printTotalTimeTaken(startTime);
    }

    public static void mergeSort(int a[]) {
        mergeSort(0, a.length - 1, a);
    }

    public static void mergeSort(int beg, int end, int[] array) {

        if (beg >= end)
            return;

        int mid = (beg + end) / 2;
        mergeSort(beg, mid, array);
        mergeSort(mid + 1, end, array);
        merge(beg, mid, end, array);

    }

    // The merge function in merge sort expects two sorted arrays as input and then
    // combines them into one sorted array.
    public static void merge(int beg, int mid, int end, int[] array) {

        // initilize leftarray with size
        int leftArray[] = new int[mid - beg + 1];

        // initilize rightarray with size
        int rightArray[] = new int[end - mid];

        // copying the left side of array in leftarray
        for (int i = 0; i < leftArray.length; i++) {

            leftArray[i] = array[i + beg];
        }

        // copying the right side of an array in rightarray
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int k = beg, i = 0, j = 0;

        while (i < leftArray.length && j < rightArray.length) {

            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {

            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}