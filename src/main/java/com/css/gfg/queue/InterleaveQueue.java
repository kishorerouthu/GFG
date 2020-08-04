package com.css.gfg.queue;

import java.util.Stack;

/**
 * Interleave the first half of the queue with second half
 * 30-08-2017
 * Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.
 * <p>
 * Only a stack can be used as an auxiliary space.
 * <p>
 * Examples:
 * <p>
 * Input :  1 2 3 4
 * Output : 1 3 2 4
 * <p>
 * Input : 11 12 13 14 15 16 17 18 19 20
 * Output : 11 16 12 17 13 18 14 19 15 20
 */
public class InterleaveQueue {

    public static void main(String[] args) {
        int a[] = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Queue<Integer> q = new ArrayCircularQueue(a);
        Queue<Integer> queue = interLeave(q);
        queue.print();
    }

    /**
     * Steps:
     * 1. Push first half of the Queue to Stack  //Q: 16 17 18 19 20, S: 15 14 13 12 11
     * 2. Pop all the elements from Stack and enqueue to Queue //Q: 16 17 18 19 20 15 14 13 12 11, S:
     * 3. Deque the first half of the Queue and enqueue it back to Queue //Q: 15 14 13 12 11 16 17 18 19 20 S:
     * 4. Repeat step1  //Q: 16 17 18 19 20, S: 11 12 13 14 15
     * 5. Interleave the elements from the stack & queue //11 16 12 17 13 18 14 19 15 20
     */
    private static Queue<Integer> interLeave(Queue<Integer> q) {
        final Stack<Integer> s = new Stack<Integer>();
        int size = q.size();
        int h = size/2;
        for (int i=0; i<h; i++) {
            s.push(q.dequeue());
        }

        while (!s.isEmpty()) {
            q.enqueue(s.pop());
        }

        for (int i=0; i<h; i++) {
            q.enqueue(q.dequeue());
        }

        for (int i=0; i<h; i++) {
            s.push(q.dequeue());
        }

        while (!s.isEmpty()) {
            q.enqueue(s.pop());
            q.enqueue(q.dequeue());
        }
        return q;
    }
}
