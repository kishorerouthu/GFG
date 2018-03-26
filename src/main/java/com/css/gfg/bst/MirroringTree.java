package com.css.gfg.bst;

/**
 * @author Kishore Routhu on 26/3/18 6:13 PM.
 */
public class MirroringTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertNode(4);
        tree.insertNode(2);
        tree.insertNode(6);
        tree.insertNode(1);
        tree.insertNode(3);
        tree.insertNode(5);
        tree.insertNode(7);


        /**
         *  Tree
         *          4
         *       2       6
         *    1     3  5    7
         */
        System.out.println("ORIGINAL TREE");
        tree.preOrderPrint();
        // 4 2 1 3 6 5 7


        mirrorTree(tree);
        /**
         * Mirrored Tree
         *       4
         *    6      2
         *  7   5  3   1
         */
        System.out.println();
        System.out.println("MIRRORED TREE");
        tree.preOrderPrint();
        // 4 6 7 5 2 3 1
    }

    private static void mirrorTree(Tree tree) {
        _mirror(tree.getRootNode());
    }

    private static Node _mirror(Node rootNode) {
        if (rootNode == null)
            return rootNode;

        Node left = _mirror(rootNode.left);
        Node right = _mirror(rootNode.right);

        rootNode.left = right;
        rootNode.right = left;
        return rootNode;
    }
}
