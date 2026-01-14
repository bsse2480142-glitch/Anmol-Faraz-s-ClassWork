class QueueLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int data = head.data;
        head = head.next;
        if (head == null) tail = null;
        return data;
    }

    public void printQueue() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// 2. The Fixed Week 8 Class
public class Week8 {

    // FIX: Non-destructive findMax using a temporary queue
    public static int findMax(QueueLinkedList q) {
        if (q.isEmpty()) return -1;

        QueueLinkedList tempQ = new QueueLinkedList();
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int val = q.dequeue();
            if (val > max) max = val;
            tempQ.enqueue(val); // Save the value to restore later
        }

        // Restore the original queue
        while (!tempQ.isEmpty()) {
            q.enqueue(tempQ.dequeue());
        }

        return max;
    }

    // FIX: Non-destructive countElements using a temporary queue
    public static int countElements(QueueLinkedList q) {
        QueueLinkedList tempQ = new QueueLinkedList();
        int count = 0;

        while (!q.isEmpty()) {
            int val = q.dequeue(); // [cite: 5436]
            count++;               // [cite: 5437]
            tempQ.enqueue(val);    // Save the value to restore later
        }

        // Restore the original queue
        while (!tempQ.isEmpty()) {
            q.enqueue(tempQ.dequeue());
        }

        return count;
    }

    public static void run() {
        System.out.println("\n--- WEEK 8: Fixed Queue Operations ---");
        QueueLinkedList q = new QueueLinkedList();

        // Test data from assignment [cite: 5386-5388]
        q.enqueue(15);
        q.enqueue(42);
        q.enqueue(7);

        System.out.println("Current Queue:");
        q.printQueue();

        System.out.println("Max element: " + findMax(q));
        System.out.println("Total elements: " + countElements(q));

        System.out.println("Queue after operations (should not be empty):");
        q.printQueue();
    }

    public static void main(String[] args) {
        run();
    }
}