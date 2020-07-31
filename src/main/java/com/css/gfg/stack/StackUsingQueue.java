package com.css.gfg.stack;

import com.css.gfg.queue.ArrayCircularQueue;
import com.css.gfg.queue.ArrayLinearQueue;
import com.css.gfg.queue.LinkedListQueue;
import com.css.gfg.queue.Queue;

/**
 * Implement Stack using the single queue
 */
public class StackUsingQueue {

    private int size;
    private Queue q;

    public StackUsingQueue(int size) {
        this.size = size;
        q = new LinkedListQueue();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void push(int data) {
        int n = q.size();
        q.enqueue(data);
        for (int i=0; i<n; i++) {
            q.enqueue(q.dequeue());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            throw new IllegalStateException("Stack is Empty...!");
        }
        return (Integer)q.dequeue();
    }

    public int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return (Integer)q.dequeue();
    }

    public void display() {
        q.print();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
    }
}
