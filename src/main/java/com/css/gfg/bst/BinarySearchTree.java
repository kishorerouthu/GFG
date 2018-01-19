package com.css.gfg.bst;

/**
 * @author Kishore Routhu on 14/1/18 7:17 PM.
 */
public class BinarySearchTree {

    /**
     * Root of BST
     */
    Node root;

    /**
     * Insert new node to the BST
     */
    public void insert(int key) {
        root = insertRec(root, key);
    }
    private Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    /**
     * Search the given key in BST
     */
    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    /**
     * Inorder traversal of BST
     * Example:           50
     *               30        70
     *            20   40    60   80
     *
     *  Inorder Traversal [20 30 40 50 60 70 80]
     */
    public void inorder() {
        System.out.print("[");
        inOrderRec(root);
        System.out.print("]");
    }
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.printf(" %d ", root.key);
            inOrderRec(root.right);
        }
    }

    /**
     * PreOrder traversal of BST
     * Example:           50
     *               30        70
     *            20   40    60   80
     *
     * PreOrder Traversal [50 30 20 40 70 60 80]
     */
    public void preOrder() {
        System.out.print("[");
        preOrder(root);
        System.out.print("]");
    }
    private void preOrder(Node root) {
        if (root != null) {
            System.out.printf(" %d ", root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * PostOrder traversal of BST
     * Example:           50
     *               30        70
     *            20   40    60   80
     *
     *  PostOrder Traversal [20 40 30 60 80 70 50]
     */
    public void postOrder() {
        System.out.print("[");
        postOrder(root);
        System.out.print("]");
    }
    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf(" %d ", root.key);
        }
    }

    /**
     * Delete node from BST
     * There are three possibilities arises
     * 1. Node to be deleted is leaf    : Simply remove from the tree
     * 2. Node to be deleted has only one child : Copy the child node to the node and delete the child
     * 3. Node to be deleted has two children : Find the inorder successor to the node. Copy contents of
     *    inorder successor to the node and delete the inorder successor
     */
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        //Base case if tree is empty
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else { //if key is same as node values, then this node should be removed
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    //Driver to test the BST operations
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        traverseBST(tree);

        System.out.println();
        System.out.println("After removing 20 from tree ::");
        tree.delete(20);
        tree.inorder();

        System.out.println();
        System.out.println("After removing 30 from tree ::");
        tree.delete(30);
        tree.inorder();

        System.out.println();
        System.out.println("After removing 50 from tree ::");
        tree.delete(50);
        tree.inorder();
    }

    private static void traverseBST(BinarySearchTree tree) {
        System.out.print("InOrder traversal of BST: ");
        tree.inorder();

        System.out.println();
        System.out.print("PreOrder traversal of BST: ");
        tree.preOrder();

        System.out.println();
        System.out.print("PostOrder traversal of BST: ");
        tree.postOrder();
    }

    public static class Node {
        public int key; //Value of node
        public Node left; //Reference to Left subtree
        public Node right; //Reference to Right subtree

        public Node(int key) {
            this.key = key;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
