package BinaryTrees;

import java.util.*;

// Main Class
public class BinaryTreeImplementation {

    // ---------- Node Class ----------
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        // So printing a Node shows its value directly
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    // ---------- Binary Tree Operations ----------
    static class BinaryTree {
        private static int idx = -1;

        // Build tree from array (-1 means null)
        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) return null;

            Node root = new Node(nodes[idx]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }

        // -------- Traversals --------
        public static void preOrder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) return;
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order (BFS)
        public static void levelOrder(Node root) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    System.out.print(curr.data + " ");
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
                System.out.println(); // next level
            }
        }

        // -------- Tree Properties --------
        public static int height(Node root) {
            if (root == null) return 0;
            return 1 + Math.max(height(root.left), height(root.right));
        }

        public static int countNodes(Node root) {
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        public static int sumOfNodes(Node root) {
            if (root == null) return 0;
            return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
        }

        public static int diameter(Node root) {
            if (root == null) return 0;

            int leftDia = diameter(root.left);
            int rightDia = diameter(root.right);
            int selfDia = height(root.left) + height(root.right) + 1;

            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }

        // -------- Subtree Check --------
        public static boolean isSubtree(Node root, Node subRoot) {
            if (root == null) return false;
            if (root.data == subRoot.data && isIdentical(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private static boolean isIdentical(Node n1, Node n2) {
            if (n1 == null && n2 == null) return true;
            if (n1 == null || n2 == null || n1.data != n2.data) return false;
            return isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
        }

        // -------- Top View --------
        static class Info {
            Node node; int hd;
            Info(Node node, int hd) { this.node = node; this.hd = hd; }
        }

        public static void topView(Node root) {
            if (root == null) return;

            Map<Integer, Node> map = new TreeMap<>(); // keeps keys sorted
            Queue<Info> q = new LinkedList<>();
            q.add(new Info(root, 0));

            while (!q.isEmpty()) {
                Info curr = q.poll();
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) q.add(new Info(curr.node.left, curr.hd - 1));
                if (curr.node.right != null) q.add(new Info(curr.node.right, curr.hd + 1));
            }

            System.out.print("Top View: ");
            for (Node node : map.values()) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }

        // -------- Lowest Common Ancestor --------
        public static Node lca(Node root, int n1, int n2) {
            if (root == null) return null;
            if (root.data == n1 || root.data == n2) return root;

            Node left = lca(root.left, n1, n2);
            Node right = lca(root.right, n1, n2);

            if (left == null) return right;
            if (right == null) return left;
            return root;
        }
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree.idx = -1; // reset index
        Node root = BinaryTree.buildTree(nodes);

        int[] subNodes = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree.idx = -1;
        Node subRoot = BinaryTree.buildTree(subNodes);

        // Print results
        System.out.println("Root: " + root);
        System.out.print("PreOrder: "); BinaryTree.preOrder(root); System.out.println();
        System.out.print("InOrder: "); BinaryTree.inOrder(root); System.out.println();
        System.out.print("PostOrder: "); BinaryTree.postOrder(root); System.out.println();
        System.out.println("LevelOrder: "); BinaryTree.levelOrder(root);
        System.out.println("Height: " + BinaryTree.height(root));
        System.out.println("Node Count: " + BinaryTree.countNodes(root));
        System.out.println("Sum of Nodes: " + BinaryTree.sumOfNodes(root));
        System.out.println("Diameter: " + BinaryTree.diameter(root));
        System.out.println("Has Subtree? " + BinaryTree.isSubtree(root, subRoot));
        BinaryTree.topView(root);

        Node lcaNode = BinaryTree.lca(root, 4, 6);
        System.out.println("LCA of 4 and 2: " + (lcaNode != null ? lcaNode.data : "null"));
    }
}
