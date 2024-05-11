package Sorting;

import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {

    public static void main(String[] args) {

        int a[] = { 34, -2, 45, 29, 8, -10, 19 };

        mergeSort(0, a.length - 1, a);
        System.out.println(Arrays.toString(a));
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