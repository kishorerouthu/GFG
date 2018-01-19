package com.css.gfg.bst;

/**
 * @author Kishore Routhu on 15/1/18 2:51 PM.
 *
 * Given a BST, transform it into greater sum tree where each node
 * contains sum of all nodes greater than that one
 *
 * Ref# src/main/resources/SumBST.png
 */
public class TransformBST {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(11);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        tree.insert(29);
        tree.insert(15);
        tree.insert(40);
        tree.insert(35);

        System.out.println("Original Tree::");
        tree.inorder();

        transform(tree);
        System.out.println("Transform Tree::");
        tree.inorder();
    }

    private static void transform(BinarySearchTree tree) {
        tree.root.key = sum(tree.root);
    }

    private static int sum(BinarySearchTree.Node root) {
        int sum = 0;
        BinarySearchTree.Node leftTree = root.left;
        while (leftTree != null) {
            sum += leftTree.key;
            leftTree = leftTree.left;
        }

        BinarySearchTree.Node rightTree = root.right;
        while (rightTree != null) {
            sum += rightTree.key;
            rightTree = rightTree.right;
        }

        return sum;
    }
}
