package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Problem Statement :
 * Add 1 to a number represented as linked list
 * <p>
 * Explanation :
 * Number is represented in linked list such that each digit corresponds to a node in linked list.
 * Add 1 to it.
 * <p>
 * Example :
 * 1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0)
 *
 * @author Kishore Routhu on 11/7/17 10:53 AM.
 */
public class Add1ToNumber {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(9);
        list.push(9);
        list.push(9);
        list.push(1);

        System.out.println("Before adding 1 :");
        list.printList();

        Node head = addOneReverse(list.getHead());
        list.setHead(head);

        System.out.println("After adding 1 :");
        list.printList();
    }

    /*
        Method 1: Using reverse of LinkedList
         Reverse given linked list.
         For example, 1-> 9-> 9 -> 9 is converted to 9-> 9 -> 9 ->1.
         Start traversing linked list from leftmost node and add 1 to it.
         If there is a carry, move to the next node. Keep moving to the next node while there is a carry.
        Reverse modified linked list and return head.
     */
    private static Node addOneReverse(Node head) {
        head = reverse(head);

        Node current = head;

        int carry = 1;
        while (current != null) {
            current.data = current.data + carry;
            if (current.data > 9) {
                current.data = 0;
                current = current.next;
                continue;
            }

            break;
        }

        return reverse(head);
    }

    private static Node reverse(Node head) {
        Node next = null;
        Node previous = null;
        Node current = head;

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
