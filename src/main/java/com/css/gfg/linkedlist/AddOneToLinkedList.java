package com.css.gfg.linkedlist;

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
 * @author Kishore Routhu on 26/05/20
 */
public class AddOneToLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(9);
        Node node2 = new Node(9);
        Node node3 = new Node(9);

        head.next = node1; node1.next = node2; node2.next = node3;
        print(head);
        head = reverse(head);
        print(head);
        addOne(head);
        head = reverse(head);
        print(head);
    }
    private static void addOne(Node head) {
        if (head == null) {
            return;
        }
        int carry = 1;
        Node current = head;
        while (current != null) {
            current.data = current.data + carry;
            if (current.data > 9) {
                current.data = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            current = current.next;
        }
    }

    private static Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node previous = head;
        Node current = head.next;
        head.next = null;
        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    private static void print(Node head) {
        if (head == null) {
            return;
        }
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data);
            sb.append("->");
            current = current.next;
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
