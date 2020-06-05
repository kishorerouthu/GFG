package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function)
 * in an efficient way. Give the complexity of your algorithm
 *
 * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 * Output:   3->2->1->4->5->6->9->8->7->NULL.
 *
 */
public class ReverseAlternativeKNodes {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Node head = list.getHead();
        LinkedList.printList(head);
        System.out.println();
        head = reverseKNodes(head, 3, true);
        LinkedList.printList(head);
    }

    private static Node reverseKNodes(Node head, int k, boolean isReverse) {
        Node next = null;
        Node previous = null;
        Node current = head;
        int c = 0;
        while (c < k && current != null) {
            if (isReverse) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            } else {
                previous = current;
                current = current.next;
                next = current;
            }
            c++;
        }

        if (next != null) {
            if (isReverse) {
                head.next = reverseKNodes(next, k, !isReverse);
            } else {
                previous.next = reverseKNodes(next, k, !isReverse);
            }
        }

        return isReverse? previous : head;
    }
}
