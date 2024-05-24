package linkedList;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        @Override
        public String toString() {
            return "Node@" + Integer.toHexString(System.identityHashCode(this));
        }
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

        void printDataAndAddress() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + "|");

                if (current.next != null) {
                    System.out.print(current.next.toString() + " -> ");
                } else {
                    System.out.print("null");
                }

                current = current.next;
            }
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

        void removeLast() {
            if (size == 0) {
                printErrorMessage("Linked List is empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node current = head;
                for (int i = 1; i < size - 1; i++) {
                    current = current.next;
                }
                tail = current;
                tail.next = null;
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
                printErrorMessage(errorMessage);
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

        private Node getNodeAt(int index) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        // here we are playing with data of linked list only
        // we are iterative through data, and then reverse it
        void reverseLinkedListDataIterative() {
            int right = size - 1;
            int left = 0;
            while (left < right) {
                Node leftNode = getNodeAt(left);
                Node rightNode = getNodeAt(right);
                swap(leftNode, rightNode);
                left++;
                right--;
            }
        }

        void swap(Node node1, Node node2) {
            int temp = node1.data;
            node1.data = node2.data;
            node2.data = temp;
        }

        void reverseLinkedListPointerIterative() {
            Node previous = null;
            Node current = head;
            while (current != null) {
                Node saveNextNode = current.next;

                current.next = previous;// previous ab current ke next ko point kr rha
                previous = current; // prev ko utha ke current pe daal diyaa
                current = saveNextNode; // current ko aage move kiya
            }
            // swap the head and tail
            Node temp = head;
            head = tail;
            tail = temp;
        }

        void removeAt(int index) {
            if (size == 0) {
                printErrorMessage("LinkedList is empty");
            } else if (index < 0 || index >= size) {
                printErrorMessage("Invalid argument: index must be in between [0-" + (getSize() - 1) + "]");
            } else if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else {
                Node previous = null;
                Node current = head;
                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                current = null; // hels garbage collection
                size--;
            }
        }

        Node kthNodeFromEnd(int k) {
            if (k > size || k <= 0) {
                throw new IllegalArgumentException("k is out of bound");
            } else {
                Node fast = head;
                Node slow = head;
                for (int i = 0; i < k; i++) { // here fast will move k times
                    fast = fast.next;
                }

                while (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        Node getMiddleNodeOfLinkedList() {
            // here fast pointer is moving two times over the linked list
            // and slow pointer is moving one time, so at last slow pointer will return
            // middle node
            if (size == 0) {
                throw new IllegalArgumentException("List is empty");
            } else {
                Node slow = head;
                Node fast = head;
                while (fast.next != null && fast.next.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        Node midNode(Node head, Node tail) {
            Node fast = head;
            Node slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        InnerLinkedList mergeTwoSortedLinkedList(InnerLinkedList l1, InnerLinkedList l2) {
            Node one = l1.head;
            Node two = l2.head;

            InnerLinkedList result = new InnerLinkedList();

            while (one != null && two != null) {
                if (one.data < two.data) {
                    result.addLast(one.data);
                    one = one.next;
                } else {
                    result.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                result.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                result.addLast(two.data);
                two = two.next;
            }

            return result;
        }

        InnerLinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                InnerLinkedList baseResult = new InnerLinkedList();
                baseResult.addLast(head.data);
                return baseResult;
            }

            Node mid = midNode(head, tail);
            InnerLinkedList leftLinkedList = mergeSort(head, mid);
            InnerLinkedList rightLinkedList = mergeSort(mid.next, tail);

            InnerLinkedList resultLinkedList = mergeTwoSortedLinkedList(leftLinkedList, rightLinkedList);
            return resultLinkedList;
        }

        void removeDuplicateFromSortedLinkedList(Node head, Node tail) {
            if (size == 0)
                return;

            InnerLinkedList result = new InnerLinkedList();

            while (this.size > 0) {
                int val = this.getFirstValueOfLinkedList();
                this.removeFirst();
                if (result.size == 0 || result.getLastValueOfLinkedList() != val) {
                    result.addLast(val);
                }
            }

            this.head = result.head;
            this.tail = result.tail;
            this.size = result.size;
        }

        void initilizeLinkedList() {
            addFirst(10);
            for (int i = 20; i <= 100; i += 10) {
                addLast(i);
            }
        }

        void printErrorMessage(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        InnerLinkedList innerLinkedList = new InnerLinkedList();
        innerLinkedList.initilizeLinkedList();
        innerLinkedList.print();
        // innerLinkedList.removeDuplicateFromSortedLinkedList(innerLinkedList.head,
        // innerLinkedList.tail);
    }

}
