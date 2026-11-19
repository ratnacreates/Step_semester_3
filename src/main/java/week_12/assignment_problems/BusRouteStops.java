class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class BusRouteStops {

    public static Node build(String[] stops) {
        if (stops.length == 0) {
            return null;
        }

        Node head = new Node(stops[0]);
        Node current = head;

        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }

        return head;
    }

    public static void printRoute(Node head) {
        Node current = head;
        int count = 0;
        Node last = null;

        while (current != null) {
            System.out.print(current.data + " -> ");
            count++;
            last = current;
            current = current.next;
        }

        System.out.println("null");

        if (head != null) {
            System.out.println("Stops: " + count +
                    ", First: " + head.data +
                    ", Last: " + last.data);
        }
    }

    public static void main(String[] args) {
        String[] stops = {"Tambaram", "Guindy", "TNagar", "Central"};

        Node head = build(stops);
        printRoute(head);
    }
}