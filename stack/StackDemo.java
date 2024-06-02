package stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String arg[]) {
        //declare stack
        Stack<Integer> st = new Stack<>();
        //push integer into stack
        st.push(10);
        st.push(20);
        System.out.println(st);
    }
}
