public class Week14 {


    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

        static class BST {
            private Node root;

            public void insert(int value) {
                root = insertRec(root, value);
            }

            private Node insertRec(Node root, int value) {
                if (root == null) return new Node(value);
                if (value < root.value) root.left = insertRec(root.left, value);
                else root.right = insertRec(root.right, value);
                return root;
            }

            public int countLeafNodes() {
                return countLeafRec(root);
            }

            private int countLeafRec(Node root) {
                if (root == null) return 0;
                if (root.left == null && root.right == null) return 1;
                return countLeafRec(root.left) + countLeafRec(root.right);
            }
        }

        public static void run() {
            System.out.println("\n--- WEEK 14: BST Advanced ---");
            BST tree = new BST();
            int[] nodes = {50, 30, 70, 20, 40, 60, 80};
            for (int n : nodes) tree.insert(n);
            System.out.println("Leaf Nodes count: " + tree.countLeafNodes());
        }
    }
