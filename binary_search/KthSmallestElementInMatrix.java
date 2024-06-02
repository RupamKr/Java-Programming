package binary_search;

import java.util.List;

import sorting.SortingUtils;

import java.util.ArrayList;

public class KthSmallestElementInMatrix {
    public static void main(String[] args) {

        // List<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // int size = 4;
        // ans = getSortedRowAndColumnMatrixOfSize(size);

        // int beg = ans.get(0).get(0);
        // int end = ans.get(size - 1).get(size - 1);
        // int mid = beg + (end - beg) / 2;
        // int count = noOfElementsLessOrEqual(ans, mid);
        // int countChatGPT = noOfElementsLessOrEqualViaChatGPT(ans, mid);
        // printMatrix(ans, size);
        // System.out.println("count " + count + " chatGPTCount " + countChatGPT);
        // System.out.println("mid " + mid);

        int[][] mat = new int[4][3];
        System.out.println(mat[0].length);

    }

    public static int kthSmallestElementInMatrix(List<ArrayList<Integer>> Matrix, int k) {
        int ans = 0;
        return ans;
    }

    public static int noOfElementsLessOrEqual(List<ArrayList<Integer>> Matrix, int ele) {
        int count = 0;
        int size = Matrix.size();
        for (int row = 0; row < size; row++) {
            if (Matrix.get(row).get(0) > ele) {
                break;
            } else if (Matrix.get(row).get(size - 1) <= ele) {
                count = count + size;
            } else {
                count = count + noOfElementsLessOrEqualInRow(Matrix.get(row), ele);
            }
        }

        return count;

    }

    static int noOfElementsLessOrEqualViaChatGPT(List<ArrayList<Integer>> Matrix, int ele) {
        int n = Matrix.size();
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (Matrix.get(row).get(col) <= ele) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    private static int noOfElementsLessOrEqualInRow(ArrayList<Integer> arrayList, int ele) {
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > ele)
                break;
            count++;
        }
        return count;
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
