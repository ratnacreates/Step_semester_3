class Node {
    int bookingId;
    Node next;

    Node(int bookingId) {
        this.bookingId = bookingId;
        this.next = null;
    }
}

public class CancelABooking {

    static Node head = null;

    public static void insert(int id) {
        Node newNode = new Node(id);

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

    public static void delete(int id) {
        if (head == null) {
            return;
        }

        if (head.bookingId == id) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null && current.next.bookingId != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.bookingId + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        insert(101);
        insert(102);
        insert(103);
        insert(104);

        System.out.println("Before cancellation:");
        display();

        delete(103);

        System.out.println("After cancellation:");
        display();
    }
}