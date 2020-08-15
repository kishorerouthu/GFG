package com.css.gfg.tree;

/**
 * Print PostOrder traversal from given Inorder and PreOrder traversals
 * Given Inorder and PreOrder traversals of a binary tree, print PostOrder traversal.
 *
 * Example:
 * Input:
 * PreOrder traversal pre[] = {1, 2, 4, 5, 3, 6}
 * Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
 *
 * Output:
 * PostOrder traversal is {4, 5, 2, 6, 3, 1}
 *
 * Traversals in the above example represents following tree
 *
 *          1
 *       /    \
 *      2       3
 *    /   \      \
 *   4     5      6
 *
 *  Algorithm :
 *              PreOrder -  Root, Left, Right
 *              InOrder -   Left, Root, Right
 *     Idea is to construct the binary tree by using the PreOrder and InOrder
 *     pre[] = {1, 2, 4, 5, 3, 6}
 *     in[] = {4, 2, 5, 1, 3, 6}
 *     q  - Global variable for the current index of the pre-order traversal
 *     l  - Left / Start index of the in-order traversal
 *     r  - Right / End index of the in-order traversal
 *
 *     Node tree (pre, in, l, r) {
 *          //Base Conditions
 *          if ((l > r) OR (l>=in.length OR r>=in.length) OR (q >= pre.length)){
 *              return null;
 *          }
 *
 *          if (l == r) {
 *              return Node(in[l]);
 *          }
 *
 *          let k = search(in, l, r, pre[q]); //search for the root in in-order traversal
 *          Node node = Node(in[k]);
 *          Node left = tree(pre, in, l, k-1);
 *          Node right = tree(pre, in, k+1, r);
 *          node.left = left;
 *          node.right = right;
 *          return node;
 *     }
 *
 *
 */
public class PreAndInOrderBTree {

    private static int q = 0;

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 5, 3, 6};
        int in[] = {4, 2, 5, 1, 3, 6};
        Node<Integer> root = tree(pre, in, 0, in.length - 1);
        BinaryTree._postOrder(root);
    }

    private static Node<Integer> tree(int pre[], int in[], int l, int r) {
        //Base Conditions
        if ((l > r) || (l>=in.length || r>in.length) || (q>=pre.length)) {      // O(1)
            return null;
        }

        int key = pre[q++];     //O(1)
        if (l == r) {           //O(1)
            return new Node(in[l]);
        }

       /* if (k == -1) {
            return null;
        }*/

        int k = search(in, l, r, key);  //R(m)
        Node node = new Node(in[k]);
        Node left = tree(pre, in, l, k-1);  //T(n/2)
        Node right = tree(pre, in, k+1, r); //T(n/2)
        node.left = left;
        node.right = right;
        return node;
    }

    private static int search(int in[], int l, int r, int data) {
        if (l > r || l >= in.length || r >= in.length) {
            return -1;
        }
        for (int i=l; i<=r; i++) {
            if (data == in[i]) {
                return i;
            }
        }
        return -1;
    }

}
