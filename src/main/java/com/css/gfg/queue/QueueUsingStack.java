package com.css.gfg.queue;

import java.util.Stack;

public class QueueUsingStack implements Queue<Integer>{

    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    public void enqueue(Integer data) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public Integer dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty...!");
        }
        return s1.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public boolean isFull() {
        throw new UnsupportedOperationException("Operation not supported...!");
    }

    public void delete() {
        s1 = null;
        s2= null;
    }

    public void print() {
        while (!s1.isEmpty()) {
            System.out.print(s1.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Queue queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(5);
        queue.print();
    }
}
