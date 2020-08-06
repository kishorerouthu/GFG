package com.css.gfg.queue;

/**
 * Sorting a Queue without extra space
 * 19-03-2018
 * Given a queue with random elements, we need to sort it. We are not allowed to use extra space. The operations allowed on queue are :
 *
 * enqueue() : Adds an item to rear of queue. In C++ STL queue, this function is called push().
 * dequeue() : Removes an item from front of queue. In C++ STL queue, this function is called pop().
 * isEmpty() : Checks if a queue is empty. In C++ STL queue, this function is called empty().
 * Examples :
 *
 * Input : A queue with elements
 *         11  5  4  21
 * Output : Modified queue with
 *          following elements
 *         4 5 11 21
 *
 * Input : A queue with elements
 *         3  2  1  2
 * Output : Modified queue with
 *          following elements
 *         1 2 2 3
 */
public class SortQueue {
    public static void main(String[] args) {
        int a[] = new int[] {11, 5, 4, 21};
        int b[] = new int[] {3, 2, 1, 2};
        Queue<Integer> q = new ArrayCircularQueue(b);
        Queue<Integer> sortedQueue = sortQueue(q);
        sortedQueue.print();
    }

    private static Queue<Integer> sortQueue(Queue<Integer> q) {
        if (q == null || q.size() == 0)
            return q;

        int n = q.size();
        for (int i=n; i>0; i--) {
            int min = q.dequeue();
            for (int j=1; j<i; j++) {
                int k = q.dequeue();
                if (k <= min) {
                    q.enqueue(min);
                    min = k;
                } else {
                    q.enqueue(k);
                }
            }
            moveMinToFront(q, n-i, min);
        }
        return q;
    }

    private static void moveMinToFront(Queue<Integer> q, int i, int min) {
            for (int j=0; j<i; j++) {
                q.enqueue(q.dequeue());
            }
            q.enqueue(min);
    }
}
