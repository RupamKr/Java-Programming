package binary_search;

import java.util.List;

import sorting.SortingUtils;

import java.util.ArrayList;

public class KthSmallestElementInMatrix {
    public static void main(String[] args) {

        List<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int size = 7;
        ans = getSortedRowAndColumnMatrixOfSize(size);

        printMatrix(ans, size);

    }

    public static int kthSmallestElementInMatrix(List<ArrayList<Integer>> Matrix, int k) {
        int ans = 0;
        return ans;
    }

    public static List<ArrayList<Integer>> getSortedRowAndColumnMatrixOfSize(int size) {
        List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(getSortedRowOfSize(size));
        for (int i = 1; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            int first = matrix.get(i - 1).get(size - 1) + SortingUtils.generateRandomNumber(7);
            row.add(first);
            for (int j = 1; j < size; j++) {
                int next = row.get(j - 1) + SortingUtils.generateRandomNumber(8);
                row.add(next);
            }
            matrix.add(row);
        }
        return matrix;
    }

    public static ArrayList<Integer> getSortedRowOfSize(int size) {
        ArrayList<Integer> row = new ArrayList<>();

        if (size > 0) {
            int first = SortingUtils.generateRandomNumber(10) + 1;
            row.add(first);
            for (int i = 1; i < size; i++) {
                int next = row.get(row.size() - 1) + SortingUtils.generateRandomNumber(7);
                row.add(next);
            }
        }
        return row;
    }

    public static void printMatrix(List<ArrayList<Integer>> matrix, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(matrix.get(i));
        }
    }
}
