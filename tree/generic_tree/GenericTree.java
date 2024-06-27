package tree.generic_tree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        private Node(int val) {
            this.data = val;
        }
    }

    public static void display(Node node) {
        String str = node.data + "->";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        for (Node child : node.children) {
            display(child);
        }
    }

    public static void main(String[] args) {
        int[] a = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

        Node root = null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < a.length; i++) {

            if (a[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node(a[i]);

                if (!st.isEmpty()) {
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);
            }
        }

        /*
         * here we are traversing in the array
         * and when we found -1, we pop() the node
         * in the stack, and if not we push the node
         * by making children of the peek node
         */

        display(root);
    }
}
