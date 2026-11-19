class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LateComersInTheLine {

    static Node head = null;

    public static void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public static void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        insertEnd(10);
        insertEnd(20);
        insertEnd(30);

        System.out.println("Original list:");
        display();

        insertFront(5);
        System.out.println("After inserting at front:");
        display();

        insertEnd(40);
        System.out.println("After inserting at end:");
        display();
    }
}