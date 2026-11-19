class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BookCopyFinder {

    static Node head = null;

    public static void insert(int data) {
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

    public static int countOccurrences(int target) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data == target) {
                count++;
            }

            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        insert(101);
        insert(202);
        insert(101);
        insert(303);
        insert(101);
        insert(202);

        int target = 101;

        System.out.println("Occurrences of " + target + ": " +
                countOccurrences(target));
    }
}