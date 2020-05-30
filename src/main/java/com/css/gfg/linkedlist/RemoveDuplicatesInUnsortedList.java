package com.css.gfg.linkedlist;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInUnsortedList {
    public static void main(String[] args) throws IOException {

        LinkedList list = new LinkedList(11, 10, 21, 5, 11, 21, 43, 60, 43);

        System.out.println("Before removing duplicates ::");
        list.printList();

        LinkedList.Node newHead = removeDuplicates(list.getHead());
        list.setHead(newHead);

        System.out.println("\n After removing duplicates :: ");
        list.printList();

    }

    private static LinkedList.Node removeDuplicates(LinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet();
        set.add(head.data);
        LinkedList.Node current = head.next;
        LinkedList.Node previous = head;
        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                previous = previous.next;
                set.add(current.data);
            }
            current = current.next;
        }
        return head;
    }

}
