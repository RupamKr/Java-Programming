package sorting;

import java.util.Random;

public class SortingUtils {

    private static final String CHARACTER = "abcdefghijklmnopqrstuvwxyz";

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

    public static String generateRandomString(int lengthOfString) {
        StringBuilder sb = new StringBuilder(lengthOfString);
        for (int i = 0; i < lengthOfString; i++) {
            int index = generateRandomNumber(CHARACTER.length());
            sb.append(String.valueOf(CHARACTER.charAt(index)));
        }
        return String.valueOf(sb.toString().charAt(0)).toUpperCase()+sb.toString().substring(1);
    }
}
