package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

public class RemoveLoop {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        /*Node node10 = list.push(10);
        Node node9 = list.push(9);
        Node node8 = list.push(8);
        Node node7 = list.push(7);
        Node node6 = list.push(6);
        Node node5 = list.push(5);*/
        Node node4 = list.push(4);
        Node node3 = list.push(3);
        //Node node2 = list.push(2);
        Node head = list.push(1);

        node4.next = node3;

        System.out.println("Before :: " + detectLoop(head));
        removeLoop(head);
        System.out.println("After :: " + detectLoop(head));
    }



    private static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        Node previous = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            previous = fast.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isLoop = false;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLoop = true;
                break;
            }
        }

        Node previous = fast;
        slow = head;
        if (isLoop) {
            while (slow != fast) {
                previous = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }

        previous.next = null;
    }
}
