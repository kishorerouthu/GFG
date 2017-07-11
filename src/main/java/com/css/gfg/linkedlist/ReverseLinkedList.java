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
        LinkedList list = new LinkedList();

        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        System.out.println("Before reverse :");
        list.printList();

        Node newHead = reverse(list.getHead());
        list.setHead(newHead);

        System.out.println("\nAfter reverse :");
        list.printList();

    }

    /*
        Method1 : iterative
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
}
