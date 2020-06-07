package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Sort the given Linked List using quicksort. which takes O(n^2) time in worst case and O(nLogn) in average and best cases, otherwise you may get TLE.
 *
 * Input:
 * In this problem, method takes 1 argument: address of the head of the linked list. The function should not read any input from stdin/console.
 * The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
 * There are multiple test cases. For each test case, this method will be called individually.
 *
 * Output:
 * Set *headRef to head of resultant linked list.
 *
 * User Task:
 * The task is to complete the function quickSort() which should set the *headRef to head of the resultant linked list.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=200
 *
 * Note: If you use "Test" or "Expected Output Button" use below example format
 *
 * Example:
 * Input:
 * 2
 * 3
 * 1 6 2
 * 4
 * 1 9 3 8
 *
 * Output:
 * 1 2 6
 * 1 3 8 9
 *
 * Explanation:
 * Testcase 1: After sorting the nodes, we have 1, 2 and 6.
 * Testcase 2: After sorting the nodes, we have 1, 3, 8 and 9.
 */
public class LinkedListQuickSort {

    public static void main(String[] args) {
        //LinkedList list = new LinkedList(1, 9, 3, 8, 2, 7, 6);
        LinkedList list = new LinkedList(1, 9, 3, 8);
        Node head = list.getHead();
        LinkedList.printList(head);
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }

        quickSort(head, head, end);
        System.out.println();
        LinkedList.printList(head);
    }

    private static void quickSort(Node head, Node start,  Node end) {
        if (isStartBeforeEnd(start, end)) {
            Node p = partition(start, end);
                Node current = head;
                while (current != null && current.next != p) {
                    current = current.next;
                }
                quickSort(head, start, current);
                quickSort(head, p.next, end);
        }
    }

    private static boolean isStartBeforeEnd(Node start, Node end) {
        if (start == null || end == null) {
            return false;
        }
        if (start == end) {
            return false;
        }
        Node current = start;
        while (current != null) {
            if (current == end) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static Node partition(Node start, Node end) {
        Node pivot = end;
        Node previous = start;
        Node current = start;
        while(current != null && current != pivot) {
            if (current.data < pivot.data) {
                swap(previous, current);
                previous = previous.next;
            }
            current = current.next;
        }
        swap(previous, pivot);
        return previous;
    }

    private static void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}
