package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 Write a function to reverse a linked list
 Given pointer to the head node of a linked list, the task is to reverse the linked list.

 Examples:

 Input : Head of following linked list
 1->2->3->4->NULL
 Output : Linked list should be changed to,
 4->3->2->1->NULL

 Input : Head of following linked list
 1->2->3->4->5->NULL
 Output : Linked list should be changed to,
 5->4->3->2->1->NULL

 Input : NULL
 Output : NULL

 Input  : 1->NULL
 Output : 1->NULL

 * @author Kishore Routhu on 10/7/17 8:11 PM.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, 2, 3, 4, 5);

        System.out.println("Before reverse :");
        list.printList();

     /*   Node head = reverse(list.getHead());
        System.out.println("\nAfter reverse :");
        LinkedList.printList(head);*/

        Node head = reverseList(list.getHead());
        LinkedList.printList(head);
    }

    /**
        Method1 : Iterative
        Iterate trough the linked list. In loop,
        1) change next to prev
        2) prev to current
        3) current to next.

        Time Complexity : O(n)
     */
    private static Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    /**
     * Method2: Recursive
     */
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
