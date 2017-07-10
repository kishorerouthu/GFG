package com.css.gfg.linkedlist;

/**
 * Problem Statement :
   Delete middle of Linked List.

   Explanation :
     Given a singly linked list, delete middle  of the linked list.
     For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

     If there are even nodes, then there would be two middle nodes,
     we need to delete the second middle element.
     For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

     If the input linked list is NULL, then it shoudl remain NULL.
     If the input linked list has 1 node, then this node should be deleted and new head should be returned.

     Input:
     You have to complete the method which takes one argument: the head of the linked list.
     You should not read any input from stdin/console.
     The class Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
     There are multiple test cases. For each test case, this method will be called individually.

     Output:
     Your function should return head  of the modified linked list.
     If linked list is empty then it should return NULL.

     Constraints:
     1 <=T<= 50
     1 <=N<= 1000
     1 <=value<= 1000

     Example:
     Input:
     2
     5
     1 2 3 4 5
     6
     2 4 6 7 5 1

     Output:
     1 2 4 5
     2 4 6 5 1
 *
 * @author Kishore Routhu on 10/7/17 4:22 PM.
 */
public class DeleteMiddle {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(10);
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.println("Before Delete Middle :: ");
        list.printList();

        list.deleteMiddle();
        System.out.println("\nAfter Delete Middle ::");
        list.printList();
    }


    static class LinkedList {
        Node head;

        class Node {
            int data;
            Node next;
            Node(int d) {
                this.data = d;
            }
        }

        /*
         * This function delete the middle element of linked list
         * If the size of list is even then from the 2 middle elements it will
         * delete the second one.
         *
         * @return new head node
         */
        public Node deleteMiddle() {

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

        public void push(int data) {
            Node new_node = new Node(data);

            if (head == null) {
                head = new_node;
                return;
            }

            new_node.next = head;
            head = new_node;

        }

        public void printList() {
            Node current = head;

            while (current != null) {
                System.out.printf("%d ", current.data);
                current = current.next;
            }
        }

    }
}
