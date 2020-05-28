package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

import java.util.Stack;

/**
 * Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
 * Examples :
 *              1.  R A D A R
 *              2. 1 2 3 2 1
 */
public class Palindrome {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(2);
        Node head = list.push(1);
        final boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    //Using Stack
    private static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        final Stack<Node> stack = new Stack<Node>();
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node top = stack.pop();
            if (current.data != top.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
}
