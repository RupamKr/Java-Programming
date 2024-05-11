package Sorting;

import java.util.Arrays;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] arg) {

        int array[] = new int[10];
        for(int i=0; i<array.length; i++){
            array[i] = SortingUtils.generateRandomNumber(101);
        }
        printArray(array);
        
    }

    public static void printArray(int array[]){
        System.out.println(Arrays.toString(array));
    }

}