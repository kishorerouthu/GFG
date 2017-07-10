package com.css.gfg.linkedlist;

import java.io.IOException;

import com.css.gfg.linkedlist.LinkedList.Node;

/**
 * Problem Statement :
 * Remove duplicates from sorted Linked List.
 * <p>
 * Explanation :
 * Complete the removeDuplicates() function which takes a list sorted in non-decreasing order
 * and deletes any duplicate nodes from the list. The list should only be traversed once.
 * <p>
 * Example :
 * Linked list is 11->11->11->21->43->43->60
 * then removeDuplicates() should convert the list to 11->21->43->60.
 * <p>
 * Input:
 * You have to complete the method which takes 1 argument: the head of the  linked list.
 * You should not read any input from stdin/console.
 * There are multiple test cases. For each test case this method will be called individually.
 * <p>
 * Output:
 * Your function should return a pointer to a linked list with no duplicate element.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 1<=size of linked lists<=50
 * <p>
 * Note: If you use "Test" or "Expected Output Button" use below example format.
 * <p>
 * Example:
 * Input
 * 2
 * 4
 * 2 2 4 5
 * 5
 * 2 2 2 2 2
 * <p>
 * Output
 * 2 4 5
 * 2
 *
 * @author Kishore Routhu on 10/7/17 4:57 PM.
 */
public class RemoveDuplicatesInSortedList {

    public static void main(String[] args) throws IOException {

        int a[] = new int[]{11, 11, 11, 21, 43, 43, 60};

        LinkedList list = new LinkedList();
        for (int i = a.length - 1; i >= 0; i--)
            list.push(a[i]);


        System.out.println("Before removing duplicates ::");
        list.printList();

        Node newHead = removeDuplicates(list.getHead());
        list.setHead(newHead);

        System.out.println("\n After removing duplicates :: ");
        list.printList();

    }

    /**
     *
     * @param head current head of the LinkedList
     * @return new head of LinkedList after remove the duplicates
     */
    private static Node removeDuplicates(Node head) {

        if (head == null || head.next == null)
            return head;

        Node previous = head;
        Node current = head.next;

        while (current != null) {

            if (previous.data == current.data) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return head;
    }

}
