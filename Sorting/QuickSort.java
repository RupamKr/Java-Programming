package Sorting;

import java.util.Arrays;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] arg) {

        int array[] = new int[10000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = SortingUtils.generateRandomNumber(10000);
        }
        System.out.print("Before Sort ");
        printArray(array);

        quickSort(array);

        System.out.print("After Sort ");
        printArray(array);
    }

    public static void quickSort(int array[]){
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int array[], int beg, int end) {

        if (beg >= end)
            return;

        // first step-> choose pivot element(random choose the pivot index)
        int pivotIndex = SortingUtils.generateRandomNumberBetweenRange(beg, end);
        int pivot = array[pivotIndex];
        SortingUtils.swap(pivotIndex, end, array);

        // second step-> performing partition
        int left = partition(pivot, beg, end, array);

        // thirt step-> quick sort left part of pivot and right part of pivot
        quickSort(array, beg, left - 1);
        quickSort(array, left + 1, end);
    }

    public static int partition(int pivot, int beg, int end, int[] array) {

        int left = beg, right = end;

        while (left < right) {
            while (array[left] <= pivot && left < right) {
                left++;
            }

            while (array[right] >= pivot && left < right) {
                right--;
            }
            SortingUtils.swap(left, right, array);
        }
        SortingUtils.swap(left, end, array);

        return left;

    }

    public static void printArray(int array[]) {
        System.out.println(Arrays.toString(array));
    }

}