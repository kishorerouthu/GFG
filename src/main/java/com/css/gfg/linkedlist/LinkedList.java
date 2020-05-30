package com.css.gfg.linkedlist;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kishore Routhu on 10/7/17 4:58 PM.
 */
public class LinkedList {

    private Node head;

    public  static
    class Node {
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

    public LinkedList() {
    }

    public LinkedList(int... data) {
        this();
        Stack<Integer> s = new Stack();
        if (data != null) {
            for (int v : data) {
                s.push(v);
            }
        }
        while (!s.isEmpty()) {
            this.push(s.pop());
        }
    }

    public LinkedList(Stack<Node> s) {
        this();
        while (!s.isEmpty()) {
            this.push(s.pop());
        }
    }

    public Node push(Node node) {
        if (isEmpty()) {
            head = node;
            return head;
        }

        node.next = head;
        head = node;

        return head;
    }

    /**
     *
     * @param data new data to be push to LinkedList
     * @return new head node of the LinkedList
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
        printList(this.head);
    }

    public static void printList(Node head) {
        Node current = head;
        System.out.printf("[");
        while (current != null) {
            System.out.printf(" %d ", current.data);
            current = current.next;
            if (current != null)
                System.out.printf(",");
        }
        System.out.printf("]");
    }
}
