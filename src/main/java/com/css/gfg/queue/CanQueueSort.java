package com.css.gfg.queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Check if a queue can be sorted into another queue using a stack
 * Given a Queue consisting of first n natural numbers (in random order). The task is to check whether the given Queue elements can be arranged in increasing order in another Queue using a stack. The operation allowed are:
 * 1. Push and pop elements from the stack
 * 2. Pop (Or enqueue) from the given Queue.
 * 3. Push (Or Dequeue) in the another Queue.
 *
 * Examples :
 *
 * Input : Queue[] = { 5, 1, 2, 3, 4 }
 * Output : Yes
 * Pop the first element of the given Queue i.e 5.
 * Push 5 into the stack.
 * Now, pop all the elements of the given Queue and push them to
 * second Queue.
 * Now, pop element 5 in the stack and push it to the second Queue.
 *
 * Input : Queue[] = { 5, 1, 2, 6, 3, 4 }
 * Output : No
 * Push 5 to stack.
 * Pop 1, 2 from given Queue and push it to another Queue.
 * Pop 6 from given Queue and push to stack.
 * Pop 3, 4 from given Queue and push to second Queue.
 * Now, from using any of above operation, we cannot push 5
 * into the second Queue because it is below the 6 in the stack.
 */
public class CanQueueSort {

    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayLinearQueue(5);
        Queue<Integer> q2 = new ArrayLinearQueue(5);
        Stack<Integer> stack = new Stack<Integer>();
        int a[] = new int[]{5, 1, 2, 3, 4};
        int b[] = new int[]{5, 1, 2, 6, 3};
        for (int data : b) {
            q1.enqueue(data);
        }

        boolean canBeSorted = canBeSorted(q1, q2, stack);
        System.out.println(canBeSorted);
    }

    private static boolean canBeSorted(Queue q1, Queue q2, Stack stack) {
        int prev = (Integer) q1.dequeue();
        while (!q1.isEmpty()) {
            int curr = (Integer) q1.dequeue();
            if (prev > curr) {
                if (!stack.isEmpty() && (Integer)stack.peek() < prev) {
                    return false;
                }
                stack.push(prev);
            } else {
                q2.enqueue(prev);
            }
            prev = curr;
        }
        return true;
    }
}
