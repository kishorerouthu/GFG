package com.css.gfg.linkedlist;

/**
 * @author Kishore Routhu on 8/7/17 9:19 AM.
 */
public class InsertNode {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(3);
        list.push(6);
        list.push(7);
        list.push(5);

        list.insertAfter(list.head.next, 8);

        list.append(10);

        list.printList();
    }



    /*
        Define Linked List with head Node
        Node contains data and the pointer to the next node
     */
    private static class LinkedList {

        Node head;

        class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }
        }

        /*Insert the node at front of linked list*/
        public void push(int new_data) {

            /* Create node and set the data */
            Node new_node = new Node(new_data);

            /* If list is empty then make new_node as head */
            if (head == null) {
                head = new_node;
                return;
            }

            /* Make next of new Node as head */
            new_node.next = head;

            /* Make the new node as head */
            head = new_node;
        }

        /*Insert data after the give node*/
        public void insertAfter(Node prev_node, int data) {

            Node new_node = new Node(data);

            /*If prev_node is null then new node becomes head*/
            if (prev_node == null) {
                head = new_node;
                return;
            }

            /*Assign prev_node next to new_node.next*/
            new_node.next = prev_node.next;

            /*Assign new_node to prev_node next*/
            prev_node.next = new_node;

        }

        /*Insert node at the end of linked list*/
        public void append(int data) {

            /* Allocate new node and set data */
            Node new_node = new Node(data);

            /* Traverse to the end of the node*/
            Node last_node = head;
            while (last_node.next != null) {
                last_node = last_node.next;
            }

            /*Append new node at end of list*/
            last_node.next = new_node;
        }

        public void printList() {
            Node next_node = head;
            while (next_node != null) {
                System.out.println(next_node.data);
                next_node = next_node.next;
            }
        }

    }
}
