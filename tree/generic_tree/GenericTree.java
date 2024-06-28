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

    public static Node tree(int[] a) {
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
        return root;
        /*
         * 1. Initialize root as null and create an empty stack.
         * 2. Traverse through each element in the array.
         * 3. If the element is -1:
         * - Pop the top node from the stack.
         * 4. If the element is not -1:
         * - Create a new node with the current element value.
         * - If the stack is not empty, add this new node as a child of the top node in
         * the stack.
         * - If the stack is empty, set this new node as the root.
         * - Push the new node onto the stack.
         * 5. Continue until the entire array is processed.
         * 6. Return the root of the constructed tree.
         */
    }

    public static void display(Node node) {
        /*
         * 1 we store the root and there child
         * 2 then we call display to all child
         */
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

    public static int size(Node node) {
        int count = 0;
        Stack<Node> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node current = st.pop();
            count++;
            for (Node child : current.children) {
                if (child != null) {
                    st.push(child);
                }
            }
        }
        return count;
    }

    public static int sizeRecursiveMethod(Node node) {
        if (node == null)
            return 0;
        int count = 1;
        for (Node child : node.children) {
            count += sizeRecursiveMethod(child);
        }
        return count;
    }

    public static int findMax(Node root) {
        int max = Integer.MIN_VALUE;
        for (Node child : root.children) {
            int mc = findMax(child);
            max = Math.max(mc, max);
        }
        max = Math.max(root.data, max);
        return max;
    }

    public static int findMin(Node root) {
        int min = Integer.MAX_VALUE;
        for (Node child : root.children) {
            int mc = findMin(child);
            min = Math.min(mc, min);
        }
        min = Math.min(root.data, min);
        return min;
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        int ht = -1;
        for (Node child : root.children) {
            int hc = height(child);
            ht = Math.max(ht, hc);
        }
        ht += 1;
        return ht;
    }

    public static void traversal(Node root) {
        System.out.println("Node pre-->" + root.data);
        for (Node child : root.children) {
            System.out.println("Edge pre " + root.data + "-->" + child.data);
            traversal(child);
            System.out.println("Edge post " + root.data + "-->" + child.data);
        }
        System.out.println("Node post-->" + root.data);
    }

    public static void main(String[] args) {
        // int[] a = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
        // 90, -1, -1, 40, 100, -1, -1, -1 };
        int[] a = { 10, 20, -1, 30, -1, -1 };

        Node root = tree(a);
        System.out.println(height(root));
    }
}