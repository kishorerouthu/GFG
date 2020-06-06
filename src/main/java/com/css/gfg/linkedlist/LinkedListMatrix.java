package com.css.gfg.linkedlist;

/**
 * Given a Matrix mat of N*N size, the task is to complete the function constructLinkedMatrix(),
 * that constructs a 2D linked list representation of the given matrix.
 * Input : 2D matrix
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Output :
 * 1 -> 2 -> 3 -> NULL
 * |    |    |
 * v    v    v
 * 4 -> 5 -> 6 -> NULL
 * |    |    |
 * v    v    v
 * 7 -> 8 -> 9 -> NULL
 * |    |    |
 * v    v    v
 * NULL NULL NULL
 *
 * Input:
 * The fuction takes 2 argument as input, first the 2D matrix mat[][] and second an integer variable N, denoting the size of the matrix.
 * There will be T test cases and for each test case the function will be called separately.
 *
 * Output:
 * The function must return the reference pointer to the head of the linked list.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=150
 *
 * Example:
 * Input:
 * 2
 * 3
 * 1 2 3 4 5 6 7 8 9
 * 2
 * 1 2 3 4
 * Output:
 * 1 2 3 4 5 6 7 8 9
 * 1 2 3 4
 */
public class LinkedListMatrix {
   static class Node
    {
        int data;
        Node right,down;

        Node(int data){
            this.data = data;
            right = null;
            down = null;
        }
    }

    static Node construct(int arr[][],int n)
    {
        Node head = null;
        Node crp = null;  //Current Row start node
        Node prp = null; //Previous Row start node
        Node p = null;  //Current moving pointer of row
        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Node node = new Node(arr[i][j]);

                //Finding the head Node
                if (i == 0 && j == 0) {
                    head = node;
                }

                //Start of the Row
                if(j == 0) {
                    crp = node;
                } else {
                    p.right = node;
                }
                p = node;
                if (prp != null) {
                    prp.down = node;
                    prp = prp.right;
                }
            }
            prp = crp;
        }

        return head;
    }
}
