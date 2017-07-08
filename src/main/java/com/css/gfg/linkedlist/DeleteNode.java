package com.css.gfg.linkedlist;

/**
 * Problem Statement :
   Given a 'key' delete the first occurrence of this key in linked list.

   To delete a node from linked list, we need to do the following steps
   1) Find previous node of node to be deleted
   2) Change next of previous node
   3) Free memory for the node to delete
   Time Complexity O(n)

   Blog Post:
   https://csstack.wordpress.com/2017/07/08/deleting-a-node-from-linked-list/

 * @author Kishore Routhu on 8/7/17 8:17 PM.
 */
public class DeleteNode {

    /* Driver method to test */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(5);
        list.push(8);
        list.push(3);
        list.push(1);
        list.push(8);
        list.push(7);

        System.out.println("Linked List before deleting the Node :");
        list.printList();

        list.delete(8);
        System.out.println("\nLinked List after deleting the Node :");
        list.printList();

    }

    private static class LinkedList {

        Node head;

        private class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }
        }

        private boolean isEmpty() {
            return head == null;
        }

        /* Push the element to the beginning of list */
        private void push(int data) {

            /* Allocate new node with given data*/
            Node new_node = new Node(data);

            /*If Linked List is empty then new_node becomes head*/
            if (isEmpty()) {
                head = new_node;
                return;
            }

            /* Assign head to next of new_node*/
            new_node.next = head;

            /* New node becomes head */
            head = new_node;
        }

        /* Delete the specified element */
        private void delete(int data) {

            Node previous = null;
            Node current = head;

            /* Traverse the list until we found given data node */
            while (current != null && current.data != data) {
                previous = current;
                current = current.next;
            }

            /* If current is null we didn't found any such data node in list */
            if (current == null) {
                System.out.printf("Given data %s not found", data);
                return;
            }

            /* Value to deleted is present at head node */
            if (previous == null) {
                head = current.next;
                return;
            }

            previous.next = current.next;
        }

        /*Print all the elements in the list*/
        private void printList() {
            Node current = head;

            while (current != null) {
                System.out.printf("%d ", current.data);
                current =  current.next;
            }
        }

    }
}
