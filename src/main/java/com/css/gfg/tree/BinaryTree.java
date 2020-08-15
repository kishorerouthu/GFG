package com.css.gfg.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree() {
    }

    public Node<T> getRoot() {
        return root;
    }

    /**
     * Insert new node to the tree it uses level order traversal
     * which uses the Queue internally
     * @param data
     */
    public void insert(T data) {
        Node<T> node = new Node<T>();
        node.data = data;
        if (root == null) {
            root = node;
        } else {
            Queue<Node<T>> q = new ArrayDeque<>();
            q.add(root);        //Add root to the Queue
            while (!q.isEmpty()) {
                Node<T> temp = q.remove();

                if (temp.left == null) {
                    temp.left = node;
                    break;
                } else
                    q.add(temp.left);

                if (temp.right == null) {
                    temp.right = node;
                    break;
                }
                else
                    q.add(temp.right);

            }
        }
    }

    private Node<T> deepestNode() {
        Node<T> node = root;
        Queue<Node<T>> q = new ArrayDeque<>();
        q.add(root);        //Add root to the Queue
        while (!q.isEmpty()) {
            node = q.remove();
            if (node != null) {
                //Enqueue the Left and Right child of node
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return node;
    }

    /**
     * Delete the given node from the tree
     * @param data
     */
    public void delete(T data) {
        if (isEmpty()) {
            System.out.println("Tree is Empty...!");
            return;
        }
        Node<T> node = search(data);
        if (node == null)
            return;
        Node<T> d_node = deepestNode();
        node.data = d_node.data;
        delete(d_node);
    }

    public void delete(Node<T> node) {
        if (node == root) {
            root = null;
            return;
        }
        Queue<Node<T>> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node<T> temp = q.remove();

            if (temp.left != null) {
                if (temp.left == node) {
                    temp.left = null;
                } else {
                    q.add(temp.left);
                }
            }

            if (temp.right != null) {
                if (temp.right == node) {
                    temp.right = null;
                } else {
                    q.add(temp.right);
                }
            }
        }
    }

    private Node<T> search(T data) {
        Queue<Node<T>> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> temp = q.remove();
            if (temp.data == data) {
                return temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return null;
    }

    /**
     * PreOrder Traversal of tree :
     *  Root, Left, Right
     */
    public void preOrder() {
        if (isEmpty()) {
            System.out.println("Tree is Empty...!");
            return;
        }
        System.out.print("Pre-Order : ");
        _preOrder(root);
    }

    private void _preOrder(Node<T> node) {
        // Base/Termination condition
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        _preOrder(node.left);
        _preOrder(node.right);
    }

    /**
     * PostOrder Traversal of tree :
     *  Left, Right, Root
     */
    public void postOrder() {
        if (isEmpty()) {
            System.out.println("Tree is Empty...!");
            return;
        }
        System.out.print("Post-Order : ");
        _postOrder(root);
    }

    public static void _postOrder(Node node) {
        //Base/Termination condition
        if (node == null) {
            return;
        }
        _postOrder(node.left);
        _postOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * InOrder Traversal of tree :
     *  Left, Root, Right
     */
    public void inOrder() {
        if (isEmpty()) {
            System.out.println("Tree is Empty...!");
            return;
        }
        System.out.print("In-Order : ");
        _inOrder(root);
    }

    private void _inOrder(Node<T> node) {
        //Base / Termination condition
        if(node == null) {
            return;
        }

        _inOrder(node.left);
        System.out.print(node.data + " ");
        _inOrder(node.right);
    }

    /**
     * This traversal will move level by level and it uses
     * the Queue data structure
     */
    public void levelOrder() {
        if (isEmpty()) {
            System.out.println("Tree is Empty...!");
            return;
        }
        System.out.print("Level-Order : ");
        final Queue<Node<T>> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> temp = q.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(20);
        tree.insert(100);
        tree.insert(3);
        tree.insert(50);
        tree.insert(15);
        tree.insert(250);
        tree.insert(35);
        tree.insert(222);
        tree.preOrder();
        System.out.println();
        tree.delete(100);
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        tree.levelOrder();

    }

}
