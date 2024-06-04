package stack;

import java.util.Arrays;
import java.util.Stack;

import sorting.SortingUtils;

public class StackDemo {
    public static int[] nextGreaterElement(int[] arr) {
        int nge[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        // we pushed index 0 to the stack
        st.push(0);
        // here we are moving from left to right;
        for (int i = 1; i < arr.length; i++) {
            // write the logic of pop;
            //here if current element is greater then pop, until you find less element in stack
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int index = st.peek();
                nge[index] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int index = st.peek();
            nge[index] = -1;
            st.pop();
        }
        return nge;
    }

    public static void main(String arg[]) {
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = SortingUtils.generateRandomNumber(100);
        }
        
        System.out.println(Arrays.toString(arr));
        int ans[] = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }
}
