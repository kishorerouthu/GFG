package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
 *
 * Input:
 * The first line of input contains the number of testcase T. For each testcase, the first line of input contains the number of nodes in the linked list and the number N. The next line contains N nodes of the linked list.
 *
 * Output:
 * For each testcase, output the data of node which is at Nth distance from the end or -1 in case node doesn't exist.
 *
 * User Task:
 * The task is to complete the function getNthFromLast() which takes two arguments: reference to head and N and you need to return Nth from the end.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= L <= 103
 * 1 <= N <= 103
 *
 * Example:
 * Input:
 * 2
 * 9 2
 * 1 2 3 4 5 6 7 8 9
 * 4 5
 * 10 5 100 5
 * Output:
 * 8
 * -1
 *
 * Explanation:
 * Testcase 1: In the first example, there are 9 nodes in linked list and we need to find 2nd node from end. 2nd node from end os 8.
 * Testcase 2: In the second example, there are 4 nodes in the linked list and we need to find 5th from the end. Since 'n' is more than the number of nodes in the linked list, the output is -1.
 */

public class NthNodeFromEnd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //Node node10 = list.push(10);
        Node node9 = list.push(9);
        Node node8 = list.push(8);
        Node node7 = list.push(7);
        Node node6 = list.push(6);
        Node node5 = list.push(5);
        Node node4 = list.push(4);
        Node node3 = list.push(3);
        Node node2 = list.push(2);
        Node head = list.push(1);

        int n = 2;
        int v = getNthNodeFromLast(head, n);
        System.out.println("Value :: " + v);
    }

    private static int getNthNodeFromLast(Node head, int n) {
        Node current = head;
        Node node = null;
        int count = 0;
        while(current != null) {
            count++;
            if (count == n) {
                node = head;
            } else if (node != null) {
                node = node.next;
            }

            current = current.next;
        }

        if(node != null) {
            return node.data;
        }
        return -1;
    }


}
