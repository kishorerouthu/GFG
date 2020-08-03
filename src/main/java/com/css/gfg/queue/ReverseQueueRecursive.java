package com.css.gfg.queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Reversing a queue using recursion
 * 29-03-2018
 * Given a queue, write a recursive function to reverse it.
 * Standard operations allowed :
 * enqueue(x) : Add an item x to rear of queue.
 * dequeue() : Remove an item from front of queue.
 * empty() : Checks if a queue is empty or not.
 *
 * Examples :
 *
 * Input : Q = [5, 24, 9, 6, 8, 4, 1, 8, 3, 6]
 * Output : Q = [6, 3, 8, 1, 4, 8, 6, 9, 24, 5]
 *
 * Explanation : Output queue is the reverse of the input queue.
 *
 * Input : Q = [8, 7, 2, 5, 1]
 * Output : Q = [1, 5, 2, 7, 8]
 */
public class ReverseQueueRecursive {
    public static void main(String[] args) {
        int a[] = new int[]{5, 24, 9, 6, 8, 4, 1, 8, 3, 6};
        Queue queue = new ArrayLinearQueue(a.length);
        for (int data : a) {
            queue.enqueue(data);
        }
        reverse(queue);
        queue.print();
    }

    private static void reverse(Queue queue) {
        if (queue.isEmpty()) {
            return;
        }
        int data = (Integer)queue.dequeue();
        reverse(queue);
        queue.enqueue(data);
    }
}
