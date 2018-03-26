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
      /*  tree.insert(11);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        tree.insert(29);
        tree.insert(15);
        tree.insert(40);
        tree.insert(35);*/

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);


        System.out.println("Original Tree::");
        tree.inorder();

        transform(tree);
        System.out.println("Transform Tree::");
        tree.inorder();
    }

    /**
     * The idea is to traverse BST in reverse inorder.
     * Reverse travers of BST gives us keys in decreasing order.
     * Before visiting node, we visit all greater nodes of that node. While traversing we keep track of
     * sum of keys which is the sum of all the keys greater than the key of current node
     */
    private static void transform(BinarySearchTree tree) {
        Integer sum = 0;
        reverseInOrder(tree.root, sum);
    }

    private static int reverseInOrder(BinarySearchTree.Node root, Integer sum) {
        if (root != null) {
            sum += reverseInOrder(root.right, sum);
            root.key += sum;
            reverseInOrder(root.left, root.key);
            return root.key;
        }
        return 0;
    }

    /**
     * Example:           50          |               260
     *               30        70     |       330             150
     *            20   40    60   80  |   350     300     210      80
     *
     *            reverseInOrder(50, 0)
     *            reverseInOrder(70, 0)
     *            reverseInOrder(80, 0) 80
     *            reverseInOrder(null, 0)
     *
     *
     */

}
