package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Problem Statement :
 * Delete middle of Linked List.
 * <p>
 * Explanation :
 * Given a singly linked list, delete middle  of the linked list.
 * For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
 * <p>
 * If there are even nodes, then there would be two middle nodes,
 * we need to delete the second middle element.
 * For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
 * <p>
 * If the input linked list is NULL, then it shoudl remain NULL.
 * If the input linked list has 1 node, then this node should be deleted and new head should be returned.
 * <p>
 * Input:
 * You have to complete the method which takes one argument: the head of the linked list.
 * You should not read any input from stdin/console.
 * The class Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
 * There are multiple test cases. For each test case, this method will be called individually.
 * <p>
 * Output:
 * Your function should return head  of the modified linked list.
 * If linked list is empty then it should return NULL.
 * <p>
 * Constraints:
 * 1 <=T<= 50
 * 1 <=N<= 1000
 * 1 <=value<= 1000
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 6
 * 2 4 6 7 5 1
 * <p>
 * Output:
 * 1 2 4 5
 * 2 4 6 5 1
 *
 * @author Kishore Routhu on 10/7/17 4:22 PM.
 */
public class DeleteMiddle {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Before Delete Middle :: ");
        list.printList();

        Node newHead = deleteMiddle(list.getHead());
        list.setHead(newHead);

        System.out.println("\nAfter Delete Middle ::");
        list.printList();
    }


    /*
     * This function delete the middle element of linked list
     * If the size of list is even then from the 2 middle elements it will
     * delete the second one.
     *
     * @return new head node
     */
    public static Node deleteMiddle(Node head) {

            /* Base case if head is null OR if lis contains only 1 node then remove it */
        if (head == null || head.next == null)
            return null;

        Node first = head;
        Node second = head;
        Node previous = null;

        while (second != null && second.next != null) {
            previous = first;
            first = first.next;
            second = second.next.next;
        }

        previous.next = first.next;

        return head;
    }

}
