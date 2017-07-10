package com.css.gfg.linkedlist;

/**
 * @author Kishore Routhu on 10/7/17 4:58 PM.
 */
public class LinkedList {

    private Node head;

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     *
     * @param data new data to be push to LinkedList
     * @return new head node of the LindeList
     */
    public Node push(int data) {

        /*Allocate new node */
        Node new_node = new Node(data);


        /* If LinkedList is Empty then new node becomes head */
        if (isEmpty()) {
            head = new_node;
            return head;
        }

        new_node.next = head;
        head = new_node;

        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /* Prints all the elements in list starting from head Node */
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.printf("%d ", current.data);
            current = current.next;
        }
    }
}
