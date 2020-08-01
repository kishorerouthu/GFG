package com.css.gfg.queue;

import java.util.Stack;

/**
 * Give an algorithm for reversing a queue Q. Only following standard operations are allowed on queue.
 *
 * enqueue(x) : Add an item x to rear of queue.
 * dequeue() : Remove an item from front of queue.
 * empty() : Checks if a queue is empty or not.
 * Examples:
 *
 * Input :  Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 * Output : Q = [100, 90, 80, 70, 60, 50, 40, 30, 20, 10]
 *
 * Input : [1, 2, 3, 4, 5]
 * Output : [5, 4, 3, 2, 1]
 */
public class ReverseQueue {

    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayLinearQueue(10);
        int a[] = new int[]{0, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for (int data : a) {
            q1.enqueue(data);
        }
        q1.print();
        Stack<Integer> stack = new Stack<>();
        while (!q1.isEmpty()) {
            stack.push(q1.dequeue());
        }
        while (!stack.isEmpty()) {
            q1.enqueue(stack.pop());
        }
        q1.print();
    }

}
