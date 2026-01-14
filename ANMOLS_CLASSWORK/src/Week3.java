public class Week3 {
    static class Node {
        int data;
        String strData;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
        Node(String strData) { this.strData = strData; this.next = null; }
    }

    static class LL {
        Node head;
        private int size;
        public void addLast(String data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) { head = newNode; return; }
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) { head = newNode; return; }
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        public void removeFirst() { if (head != null) { head = head.next; size--; } }
        public void removeLast() {
            if (head == null) return;
            size--;
            if (head.next == null) { head = null; return; }
            Node sl = head;
            while (sl.next.next != null) sl = sl.next;
            sl.next = null;
        }
        public int searchElement(int target) {
            Node curr = head; int idx = 0;
            while (curr != null) { if (curr.data == target) return idx; curr = curr.next; idx++; }
            return -1;
        }
        public void deleteLessThanTen() {
            while (head != null && head.data < 10) { head = head.next; size--; }
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (curr.next.data < 10) { curr.next = curr.next.next; size--; }
                else curr = curr.next;
            }
        }
        public void printList() {
            Node curr = head;
            while (curr != null) {
                System.out.print(((curr.strData != null) ? curr.strData : curr.data) + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void run() {
        System.out.println("\n--- WEEK 3: Singly Linked List ---");
        LL list = new LL();
        list.addLast("this"); list.addLast("is"); list.addLast("a"); list.addLast("list");
        list.removeFirst(); list.printList();

        LL numList = new LL();
        numList.addLast(5); numList.addLast(15); numList.addLast(8);
        System.out.print("Search 15 index: " + numList.searchElement(15));
        numList.deleteLessThanTen();
        System.out.print("\nAfter deleting < 10: "); numList.printList();
    }
}