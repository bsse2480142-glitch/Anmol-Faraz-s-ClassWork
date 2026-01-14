public class Week6 {
    static class DoublyLL {
        Node head, tail;
        class Node {
            int data; Node next, prev;
            Node(int data) { this.data = data; }
        }
        public void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) { head = tail = newNode; return; }
            tail.next = newNode; newNode.prev = tail; tail = newNode;
        }
        public void reverseDLL() {
            Node curr = head, temp = null;
            while (curr != null) {
                temp = curr.prev; curr.prev = curr.next; curr.next = temp;
                curr = curr.prev;
            }
            if (temp != null) head = temp.prev;
        }
        public void printForward() {
            Node temp = head;
            while (temp != null) { System.out.print(temp.data + " <-> "); temp = temp.next; }
            System.out.println("null");
        }
    }

    public static void run() {
        System.out.println("\n--- WEEK 6: Doubly Linked List ---");
        DoublyLL list = new DoublyLL();
        list.addLast(10); list.addLast(20); list.addLast(30);
        list.printForward();
        System.out.println("Reversing...");
        list.reverseDLL();
        list.printForward();
    }
}