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
        }

        int getSize() {
            return size;
        }

        void removeFirst() {
            // if size is zero -> print linkedlist is empty;
            if (size == 0) {
                System.out.println("Linked List is empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node temp = head;
                head = temp.next;
                temp.next = null; // handle garbage value, if we don't assign null, it means it will take memory
                size--;

                // we can write like this also
                // head = head.next;
                // size--;
            }
        }
        
        void removeLast(){
            if(size==0){
                System.out.println("Linked List is empty");
            }else if(size==1){
                head=tail=null;
                size--;
            }else{
                Node current = head;
                for(int i=1; i<size-1; i++){
                    current=current.next;
                }
                tail = current;
                tail.next=null;
                size--;
            }
        }

        int getFirstValueOfLinkedList() {
            return head.data;
        }

        int getLastValueOfLinkedList() {
            return tail.data;
        }

        int getNthIndexValue(int index) {
            if (size == 0) {
                System.out.println("Linked List is empty");
                return -1;
            } else if (index < 0 || index >= size) {
                System.out.println("Invalid argument");
                return -1;
            } else {
                int count = 1;
                Node current = head;
                while (count <= index) {
                    current = current.next;
                    count++;

                }
                return current.data;
            }
        }

        void addAtNthIndexOfLinkedList(int value, int index) {
            if (index == 0) {
                addFirst(value);
            } else if (index == size) {
                addLast(value);
            } else if (index < 0 || index > size) {
                String errorMessage = index < 0 ? "Index must be positive integer" : "Invalid argument";
                System.out.println(errorMessage);
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node temp = new Node();
                temp.data = value;
                temp.next = current.next;
                current.next = temp;
                size++;
            }
        }

        void initilizeLinkedList() {
            addFirst(10);
            for (int i = 20; i <= 80; i += 10) {
                addLast(i);
            }
        }
    }

    public static void main(String[] args) {
        InnerLinkedList innerLinkedList = new InnerLinkedList();
        innerLinkedList.initilizeLinkedList();
        innerLinkedList.print();
    }

}
