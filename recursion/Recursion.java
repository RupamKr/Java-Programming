package recursion;

import java.util.ArrayList;

import sorting.SortingUtils;

public class Recursion {

    public static ArrayList<String> subSequenceArray(int array[], int size) {

        if (size == 0) {
            ArrayList<String> bc = new ArrayList<>();
            bc.add(" ");
            return bc;
        }

        ArrayList<String> list = subSequenceArray(array, size - 1);

        return list;
    }

    public static void main(String[] arg) {

        int array[] = new int[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = SortingUtils.generateRandomNumber(20);
        }
        ArrayList<String> result = subSequenceArray(array, array.length);
        System.out.println(result);
    }
}
