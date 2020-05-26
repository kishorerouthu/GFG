package com.css.gfg.linkedlist;

import com.css.gfg.linkedlist.LinkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class DetectLoop {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Node node10 = list.push(10);
        Node node9 = list.push(9);
        Node node8 = list.push(8);
        Node node7 = list.push(7);
        Node node6 = list.push(6);
        Node node5 = list.push(5);
        Node node4 = list.push(4);
        Node node3 = list.push(3);
        Node node2 = list.push(2);
        Node head = list.push(1);

        node10.next = node4;


        boolean isLoop = detectLoop(head);
        System.out.println(isLoop);

    }

    private static boolean detectLoop(Node head) {
        final List<Node> list = new ArrayList<Node>();
        Node current = head;
        while (current != null) {
            if (list.contains(current)) {
                return true;
            } else {
                list.add(current);
            }
            current = current.next;
        }
        return false;
    }
}
