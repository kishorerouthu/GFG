package com.css.gfg.stack;

import com.css.gfg.queue.Dequeue;

/**
 * Implement stack using Dequeue
 */
public class StackUsingDequeue {
    private Dequeue dequeue;

    public StackUsingDequeue() {
        dequeue = new Dequeue(5);
    }

    public void push(int data) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full...!");
        }
        dequeue.enqueueRear(data);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty...!");
        }
        return dequeue.dequeueRear();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty...!");
        }
        return dequeue.getRear();
    }

    public boolean isEmpty() {
        return dequeue.isEmpty();
    }

    public boolean isFull() {
        return dequeue.isFull();
    }

    public static void main(String[] args) {
        StackUsingDequeue stack = new StackUsingDequeue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
