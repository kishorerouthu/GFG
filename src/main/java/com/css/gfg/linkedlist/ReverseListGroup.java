package com.css.gfg.linkedlist;

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
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);

        head.next = node1; node1.next = node2; node2.next = node3;
        node3.next = node4; //node4.next = node5; node5.next = node6; node6.next = node7;
        int k = 3;
        print(head);
        head = reverse(head, k);
        print(head);
    }

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
                    tail1 = tail2;
                }
                count = 1;
            }
        }
        return head;
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
