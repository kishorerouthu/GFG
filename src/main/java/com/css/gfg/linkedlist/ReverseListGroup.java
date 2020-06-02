package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 Problem Statement :
 Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

 Input:
 First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the linked list elements.

 Output:
 For each testcase, there will be a single line of output which contains the linked list with every k group elements reversed.

 User Task:
 The task is to complete the function reverse() which should reverse the linked list in group of size k.

 Expected Time Complexity : O(n)
 Expected Auxilliary Space : O(1)

 Example:
 Input:
 2
 8
 1 2 2 4 5 6 7 8
 4
 5
 1 2 3 4 5
 3

 Output:
 4 2 2 1 8 7 6 5
 3 2 1 5 4

 Explanation:
 Testcase 1: Since, k = 4. So, we have to reverse everty group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 */
public class ReverseListGroup  {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, 2, 3, 4, 5, 6, 7, 8);
        int k = 3;
        Node head = list.getHead();
        LinkedList.printList(head);
        head = rreverse(head, k);
        System.out.println();
        LinkedList.printList(head);
    }

    /**
     * Iterative approach
     */
    private static Node reverse(Node head, int k) {
        if (head == null) {
            return head;
        }
        Node thead = head;
        Node previous = head;
        Node tail1 = head;
        Node current = head.next;
        Node tail2 = null;
        Node head2 = null;
        head.next = null;
        tail1.next = null;
        int count = 1;
        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            count++;
            if (count == k || current == null) {
                if (thead == head) {
                    head = previous;
                    previous = current;
                    tail2 = current;
                    current = current.next;
                    tail2.next = null;
                } else {
                    head2 = previous;
                    tail1.next = head2;
                    if (tail2 != null) {
                        tail2.next = null;
                    }
                    tail1 = tail2;
                    tail2 = current;
                }
                count = 1;
            }
        }
        return head;
    }

    private static Node rreverse(Node head, int k) {
        Node next = null;
        Node previous = null;
        Node current = head;
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = rreverse(next, k);
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
}
