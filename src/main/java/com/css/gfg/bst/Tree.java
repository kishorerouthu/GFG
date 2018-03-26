package com.css.gfg.bst;

/**
 * @author Kishore Routhu on 26/3/18 6:02 PM.
 */
public class Tree {
    private Node rootNode;

    public void insertNode(int value) {
        rootNode = _insertNode(rootNode, value);
    }

    public Node getRootNode() {
        if (rootNode == null) {
            throw new RuntimeException("Tree is Empty");
        }
        return rootNode;
    }

    public void preOrderPrint() {
        _preOrderPrint(rootNode);
    }

    public void _preOrderPrint(Node rootNode) {
        if (rootNode != null)
            System.out.printf("%2d", rootNode.data);

        if (rootNode.left != null)
            _preOrderPrint(rootNode.left);

        if (rootNode.right != null)
            _preOrderPrint(rootNode.right);
    }


    private Node _insertNode(Node rootNode, int value) {
        if (rootNode == null)
            rootNode = new Node(value);
        else if (value < rootNode.data)
            rootNode.left = _insertNode(rootNode.left, value);
        else
            rootNode.right = _insertNode(rootNode.right, value);
        return rootNode;
    }

}
