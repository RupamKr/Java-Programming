package LinkedList;

public class LinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class InnerLinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int value) {
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        void addFirst(int value) {
            Node temp = new Node();
            temp.data = value;
            temp.next = head;
            head = temp;
            if (size == 0)
                tail = temp;
            size++;
        }

        void print() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
            System.out.println("Size of linked list is "+size);
        }
    }

    public static void main(String[] args) {
        InnerLinkedList innerLinkedList = new InnerLinkedList();
        innerLinkedList.addFirst(10);

        for (int i = 20; i <= 80; i = i + 10) {
            innerLinkedList.addLast(i);
        }
        
        innerLinkedList.print();
    }

}
