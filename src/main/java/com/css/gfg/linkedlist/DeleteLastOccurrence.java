package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Delete the Last Occurrence of element in the List
 * Example :
 * Input : 1 2 3 2 4 5 2 9
 *         2
 * Output : 1 2 3 2 4 5 9
 *
 */
public class DeleteLastOccurrence {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, 2 ,3, 2, 4, 5, 2, 9);
        Node head = list.getHead();
        LinkedList.printList(head);
        head = removeLastOccurrence(head, 2);
        System.out.println();
        LinkedList.printList(head);
    }

    private static Node removeLastOccurrence(Node head, int k) {
        Node pn = null;
        Node n = null;
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.data == k) {
                n = current;
                pn = previous;
            }
            previous = current;
            current = current.next;
        }

        if (n != null) {
            if (pn != null) {
                pn.next = n.next;
            } else {
                head = n.next;
            }
        }
        return head;
    }
}
