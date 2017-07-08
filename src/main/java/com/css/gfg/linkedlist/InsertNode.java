package com.css.gfg.linkedlist;

/**
   Problem Statement :
   Insert a node in linked list

   Explanation :
   A node can be added in three ways
   1) At the front of the linked list
   2) After a given node.
   3) At the end of the linked list.

     Add a node at the front:
     The new node is always added before the head of the given Linked List.
     And newly added node becomes the new head of the Linked List.

     Example:
     Linked List is 10->15->20->25 and we add an item 5 at the front,
     then the Linked List becomes 5->10->15->20->25.

     Time Complexity O(1)

     Add a node after a given node:
     We are given pointer to a node,
     and the new node is inserted after the given node.


     Add a node at the end:
     The new node is always added after the last node of the given Linked List.

     Example :
     Linked List is 5->10->15->20->25 and we add an item 30 at the end,
     then the Linked List becomes 5->10->15->20->25->30.
     Since a Linked List is typically represented by the head of it,
     we have to traverse the list till end and then change the next of last node to new node.

 * @author Kishore Routhu on 8/7/17 9:19 AM.
 */
public class InsertNode {

    /* Driver method to test */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(3);
        list.push(6);
        list.push(7);
        list.push(5);

        list.insertAfter(list.head.next, 8);

        list.append(10);

        System.out.println("Linked List : ");
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
        public void push(int data) {

            /* Create node and set the data */
            Node new_node = new Node(data);

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
                System.out.printf("%d ",next_node.data);
                next_node = next_node.next;
            }
        }

    }
}
