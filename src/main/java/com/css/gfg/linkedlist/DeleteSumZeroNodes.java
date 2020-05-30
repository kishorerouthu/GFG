package com.css.gfg.linkedlist;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given some resources in the form of linked list you have to canceled out all the resources whose sum up to 0(Zero) and return the remaining list.
 *
 * E.g-->> 6 -6 8 4 -12 9 8 -8
 *
 * the above example lists which gets canceled :
 * 6 -6
 * 8 4 -12
 * 8 -8
 * o/p : 9
 * case 3 : 4 6 -10 8 9 10 -19 10 -18 20 25
 * O/P : 20 25
 */
public class DeleteSumZeroNodes {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(6, -6, 8, 4, -12, 9, 8, -8);
        LinkedList.Node head = list.getHead();
        head = deleteUsingPrefixSum(head);
        System.out.println();
        LinkedList.printList(head);

        list = new LinkedList(4, 6, -10, 8, 9, 10, -19, 10, -18, 20, 25);
        head = list.getHead();
        LinkedList list1 = deletedUsingStack(head);
        System.out.println();
        list1.printList();
    }

    /**
     * Method 1: Using the Prefix Sum Algorithm
     * E.g-->>      6  -6   8   4   -12   9   8   -8
     * Prefix Sum   6   0   8  12    0    9   17   9
     * Note : Add dummy node before head (0, 0)
     * Hash [sum, node] = [{0, 0}, {6, 6}, {0, -6}, {8, 8}, {12, 4}, {0, 12}, {9, 9}, {17, 8}, {9, -18}]
     * Now traverse through the LinkedList calculate the accumulated sum let be pSum
     * Node currentNode
     * if (!hash.contains(pSum)) {
     *     hash.put(pSum, Node)
     * } else {
     *    Node pNode = has.get(pSum);
     *    Step1: Delete the hash entries from the pNode (exclude) to currentNode (include)
     *    Step2: Change the link from pNode->next to currentNode.next.
     * }
     */
      private static LinkedList.Node deleteUsingPrefixSum(LinkedList.Node head) {
          if (head == null) {
              return head;
          }
          LinkedList.Node dummy = new LinkedList.Node(0);
          dummy.next = head;
          LinkedList.Node current = dummy;
          HashMap<Integer, LinkedList.Node> map = new HashMap<Integer, LinkedList.Node>();
          int pSum = 0;
          while (current != null) {
              pSum += current.data;
              if (map.containsKey(pSum)) {
                  LinkedList.Node pNode = map.get(pSum);

                  //Step1: Delete the hash entries from the pNode (exclude) to currentNode (include)
                  int SUM = pSum;
                  LinkedList.Node temp = pNode.next;
                  while (temp != current) {
                      SUM += temp.data;
                      map.remove(SUM);
                      temp = temp.next;
                  }

                  //Step2: Change the link from pNode->next to currentNode.next.
                  pNode.next = current.next;
              } else {
                  map.put(pSum, current);
              }
              current = current.next;
          }

          return dummy.next;
      }
    /**
     * Method 2: Using Stack
     * @return
     */
    private static LinkedList deletedUsingStack(LinkedList.Node head) {
        Stack<LinkedList.Node> stack = new Stack<LinkedList.Node>();
        LinkedList.Node current = head;
        while (current != null) {
            if (current.data < 0) {
                int sum = current.data;
                while (!stack.isEmpty()) {
                    LinkedList.Node temp = stack.pop();
                    sum += temp.data;
                    if (sum == 0) {
                        //current = stack.peek();
                        break;
                    }
                }
            } else {
                stack.push(current);
            }
            current = current.next;
        }
        return new LinkedList(stack);
    }

}
