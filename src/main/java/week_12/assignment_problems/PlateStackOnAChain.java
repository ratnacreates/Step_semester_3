class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PlateStackOnAChain {

    static Node top = null;

    public static void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public static int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = top.data;
        top = top.next;
        return value;
    }

    public static int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }

        return top.data;
    }

    public static void display() {
        Node current = top;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        System.out.println("Stack:");
        display();

        System.out.println("Top element: " + peek());

        System.out.println("Popped: " + pop());

        System.out.println("Stack after pop:");
        display();
    }
}