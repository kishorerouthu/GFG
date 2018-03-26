package com.css.gfg.bst;

/**
 * Problem Statement : Find the height of binary tree
 * Example :            1
 *                  2       3
 *               4     5
 *         Answer : 2 ( Height is the depth of tree)
 *
 *  Algorithm :
 *      maxDepth()
 *      1. If tree is empty return 0
 *      2. Else
 *          a) Get the max depth of left subtree recursively i.e
 *              call maxDepth(tree --> left-subtree)
 *          b) Get the max depth of right subtree recursively i.e
 *              call maxDepth(tree --> right-subtree)
 *          c) Get the max of max depths of left and right subtrees and add 1 to it for current node.
 *              max_depth = max( max depth of left subtree + max depth of right subtree) + 1
 *
 * @author Kishore Routhu on 26/3/18 4:03 PM.
 */
public class HeightOfTree {


    public static void main(String[] args) {
       int a[] = new int[] {3, 2, 4, 5, 1, 6};
        //int a[] = new int[] {1, 2, 3, 4, 5, 6};
        Tree tree = buildTree(a, a.length);
        tree.preOrderPrint();

        int height = maxHeight(tree.getRootNode());
        System.out.printf("Height Of Tree : %d ", height);
    }

    private static int maxHeight(Node rootNode) {
        if (rootNode == null)
            return 0;
        int leftHeight = maxHeight(rootNode.left);
        int rightHeight = maxHeight(rootNode.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static Tree buildTree(int a[], int n) {
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insertNode(a[i]);
        }
        return tree;
    }
}
