package com.css.gfg.bst;

/**
 * @author Kishore Routhu on 14/1/18 7:17 PM.
 */
public class BinarySearchTree {

    class Node {
        int key; //Value of node
        Node left; //Reference to Left subtree
        Node right; //Reference to Right subtree

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



    //root of BST
    Node root;

    //Insert new node into BST
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


    //Inorder traversal of BST
    void inorder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }

    //Delete node from BST
    void delete(int key) {
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

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();

        System.out.println("After removing 20 from tree ::");
        tree.delete(20);
        tree.inorder();

        System.out.println("After removing 30 from tree ::");
        tree.delete(30);
        tree.inorder();

        System.out.println("After removing 50 from tree ::");
        tree.delete(50);
        tree.inorder();
    }
}
