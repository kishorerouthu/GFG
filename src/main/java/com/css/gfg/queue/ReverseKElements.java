package com.css.gfg.queue;

import java.util.Stack;

/**
 * Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue, leaving the other elements in the same relative order.
 *
 * Only following standard operations are allowed on queue.
 *
 * enqueue(x) : Add an item x to rear of queue
 * dequeue() : Remove an item from front of queue
 * size() : Returns number of elements in queue.
 * front() : Finds front item.
 * Examples:
 *
 * Input : Q = [10, 20, 30, 40, 50, 60,
 *             70, 80, 90, 100]
 *         k = 5
 * Output : Q = [50, 40, 30, 20, 10, 60,
 *              70, 80, 90, 100]
 *
 * Input : Q = [10, 20, 30, 40, 50, 60,
 *             70, 80, 90, 100]
 *         k = 4
 * Output : Q = [40, 30, 20, 10, 50, 60,
 *              70, 80, 90, 100]
 */
public class ReverseKElements {

    /**
     * Method1 : Reverse using Queue & Dequeue
     * 1. Push first K elements to Queue
     * 2. Enqueue all the K elements from Queue to Dequeue
     */
    public static void reverse() {
        int a[] = new int[] {50, 40, 30, 20, 10, 60, 70, 80, 90, 100};
        int k = 5;
        Queue<Integer> q = new ArrayLinearQueue(k);
        Dequeue dequeue = new Dequeue(a.length);
        for(int data : a) {
            dequeue.enqueueRear(data);
        }
        int c=0;
        while (c < k) {
            q.enqueue(dequeue.dequeueFront());
            c++;
        }

        while (!q.isEmpty()) {
            dequeue.enqueueFront(q.dequeue());
        }

        dequeue.display();
    }

    /**
     * Method2 : Reverse using Stack & Queue
     * 1. Push first K elements to Stack
     * 2. Enqueue all the K elements from Stack to Queue
     * 3. deque all the K elements from the Queue and Push back to Queue
     */
    public static void reverse1() {
        int a[] = new int[] {50, 40, 30, 20, 10, 60, 70, 80, 90, 100};
        int k = 5;
        Queue<Integer> q = new ArrayCircularQueue(a);
        Stack<Integer> s = new Stack<>();
        q.print();

        int c=0;
        while (c < k) {
            s.push(q.dequeue());
            c++;
        }

        while (!s.isEmpty()) {
            q.enqueue(s.pop());
        }

        c = 0;
        while (c < k) {
            q.enqueue(q.dequeue());
            c++;
        }

        q.print();
    }

    public static void main(String[] args) {
        //reverse();
        reverse1();
    }

}
