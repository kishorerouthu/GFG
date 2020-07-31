package com.css.gfg.stack;

import com.css.gfg.queue.ArrayLinearQueue;
import com.css.gfg.queue.Queue;

/**
 * Implement the Stack using Queue
 * Stack can be implemented using 2 queues by following 2 approaches
 * 1. By making push operation costly
 * 2. By maker pop operation costly
 */
public class StackUsing2Queues {

    private int size;
    private Queue q1 = null;
    private Queue q2 = null;

    public StackUsing2Queues(int size) {
        q1 = new ArrayLinearQueue(size);
        q2 = new ArrayLinearQueue(size);
    }

    public void push(int data) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full...!");
        }
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        q1.enqueue(data);
        while (!q2.isEmpty()) {
            q1.enqueue(q2.dequeue());
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty...!");
        }
        return (Integer)q1.dequeue();
    }

    public boolean isFull() {
        return q1.isFull();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void display() {
        q1.print();
    }

    public static void main(String[] args) {
        StackUsing2Queues stack = new StackUsing2Queues(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
    }
}
