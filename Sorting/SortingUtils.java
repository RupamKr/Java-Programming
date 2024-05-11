package Sorting;

import java.util.Random;

public class SortingUtils {

    public static void swap(int x, int y, int[] array) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static int generateRandomNumberBetweenRange(int range1, int range2) {
        Random random = new Random();
        return random.nextInt(range2 - range1) + range1;
        // note random.nextInt(100)-> it means it will generate random number between
        // 0-99, 100 will exclude from the range;
    }

    public static int generateRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }
}
