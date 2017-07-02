package com.css.gfg.linkedlist;

/**
   Problem Statement : Swap nodes in a linked list without swapping data
   Explanation : Given a linked list and two keys in it, swap nodes for two given keys.
   Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields.

   It may be assumed that all keys in linked list are distinct.
   Examples:

    Input:  10->15->12->13->20->14,  x = 12, y = 20
    Output: 10->15->20->13->12->14

    Input:  10->15->12->13->20->14,  x = 10, y = 20
    Output: 20->15->12->13->10->14

    Input:  10->15->12->13->20->14,  x = 12, y = 13
    Output: 10->15->13->12->20->14

    Solution :

     This may look a simple problem, but is interesting question as it has following cases to be handled.
     1) x and y may or may not be adjacent.
     2) Either x or y may be a head node.
     3) Either x or y may be last node.
     4) x and/or y may not be present in linked list.

     The idea it to first search x and y in given linked list.
     If any of them is not present, then return.
     While searching for x and y, keep track of current and previous pointers.
     First change next of previous pointers, then change next of current pointers.
     Following are C and Java implementations of this approach.

 CJavaPython


 * @author Kishore Routhu on 2/7/17 6:34 PM.
 *
 */
public class SwapNodes {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.println("Linked list before swap nodes");
        list.println();

        list.swapNodes(3, 7);

        System.out.println("\nLinked list after swap nodes");
        list.println();

    }

    private static class LinkedList {
        Node head;

        public void push(int data) {
            //1. Allocate new node
            Node new_node = new Node(data);
            //2. Mark next of new node as head
            new_node.next = head;
            //3. Move the to point to new node
            head = new_node;
        }

        public void println() {
            Node node = head;
            while (node != null) {
                System.out.printf("%3d", node.data);
                node = node.next;
            }
        }

        public void swapNodes(int x, int y) {

            if (x == y)
                return;

            Node prevX = null, currX = head;
            while (currX != null && currX.data != x) {
                prevX = currX;
                currX = currX.next;
            }

            Node prevY = null, currY = head;
            while (currY != null && currY.data != y) {
                prevY = currY;
                currY = currY.next;
            }

            //If x is not head of linked list
            if (prevX != null)
                prevX.next = currY;
            else
                head = currY;

            //If y is not head of linked list
            if (prevY != null)
                prevY.next = currX;
            else
                head = currX;

            //Swap next pointers
            Node temp = currY.next;
            currY.next = currX.next;
            currX.next = temp;
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}
