import java.util.*;

// 1. Supporting Node Class
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// 2. Binary Search Tree (BST) Logic
class BST {
    Node root;

    // INSERT (Recursive) [cite: 4482-4487]
    public Node insertRecursive(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insertRecursive(root.left, val);
        else root.right = insertRecursive(root.right, val);
        return root;
    }

    // INORDER TRAVERSAL [cite: 4489-4494]
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // SEARCH RECURSIVELY [cite: 4496-4500]
    public boolean searchRecursive(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return key < root.data ? searchRecursive(root.left, key) : searchRecursive(root.right, key);
    }

    // COUNT LEAF NODES [cite: 4502-4506]
    public int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // HEIGHT OF TREE [cite: 4508-4511]
    public int getHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // VALIDATE BST [cite: 4513-4517]
    public boolean isValidBST(Node root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.data <= min) || (max != null && root.data >= max)) return false;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }

    // FIND MIN & MAX [cite: 4519-4528]
    public int findMin(Node root) {
        Node current = root;
        while (current.left != null) current = current.left;
        return current.data;
    }
    public int findMax(Node root) {
        Node current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    // DELETE NODE (Practice 8) [cite: 4530-4541]
    public Node deleteNode(Node root, int key) {
        if (root == null) return null;
        if (key < root.data) root.left = deleteNode(root.left, key);
        else if (key > root.data) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.data = findMin(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }
}

// 3. Encapsulated Week 13 Class
public class Week13 {

    // This method handles all the practice tasks to keep Main clean
    public static void run() {
        BST tree = new BST();

        // --- Practice 1 & 2: Building and Printing ---
        System.out.println("--- WEEK 13: BST Practice Set ---");
        int[] practiceValues = {5, 1, 3, 4, 2}; // [cite: 4547]
        Node practiceRoot = null;
        for (int val : practiceValues) {
            practiceRoot = tree.insertRecursive(practiceRoot, val);
        }

        System.out.print("Inorder (Sorted): ");
        tree.inorder(practiceRoot); // Should print: 1 2 3 4 5

        // --- Practice 3 to 7: Properties ---
        System.out.println("\nSearch for 3: " + tree.searchRecursive(practiceRoot, 3)); // [cite: 4552]
        System.out.println("Leaf Nodes: " + tree.countLeafNodes(practiceRoot)); // [cite: 4553]
        System.out.println("Tree Height: " + tree.getHeight(practiceRoot)); // [cite: 4554]
        System.out.println("Valid BST? " + tree.isValidBST(practiceRoot, null, null)); // [cite: 4555]
        System.out.println("Min: " + tree.findMin(practiceRoot) + " | Max: " + tree.findMax(practiceRoot));

        // --- Mini Challenge: Deletion ---
        System.out.println("\n--- WEEK 13: Mini Challenge ---");
        Node challengeRoot = null;
        int[] challengeVals = {50, 30, 70, 20, 40, 60, 80}; // [cite: 4560]
        for (int val : challengeVals) {
            challengeRoot = tree.insertRecursive(challengeRoot, val);
        }

        System.out.print("Initial Tree (Inorder): ");
        tree.inorder(challengeRoot);
        System.out.println("\nDeleting 30...");
        challengeRoot = tree.deleteNode(challengeRoot, 30); // [cite: 4564]
        System.out.print("After Deletion (Inorder): ");
        tree.inorder(challengeRoot);
        System.out.println("\n");
    }
}