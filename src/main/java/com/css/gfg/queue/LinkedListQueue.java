package com.css.gfg.queue;


import com.css.gfg.linkedlist.LinkedList;

/**
 * This is Linked List based implementation of the queue.
 * Following operations can be performed on this queue.
 * 1. create queue
 * 2. enqueue
 * 3. dequeue
 * 4. delete queue
 * 5. isEmpty
 * 6. isFull
 * Example :
 *      [1, 4, 5, 2, , , ]      F - front
 *       F        R             R - rear
 */
public class LinkedListQueue implements Queue<Integer> {

    private LinkedList queue;
    private LinkedList.Node front;
    private LinkedList.Node rear;

    public LinkedListQueue() {
        queue = new LinkedList();
    }

    public void enqueue(Integer data) {
        LinkedList.Node node = new LinkedList.Node(data);
        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public Integer dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty...!");
        }
        int data = front.data;
        front = front.next;
        return data;
    }

    public boolean isEmpty() {
        return rear == null;
    }

    public boolean isFull() {
        throw new UnsupportedOperationException("IsFull is not supported by LinkedList Queue");
    }

    public void delete() {
        front = null;
        rear = null;
    }

    public void print() {
        LinkedList.Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        LinkedList.Node temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    @Override
    public Integer front() {
        return front.data;
    }

    @Override
    public Integer rear() {
        return rear.data;
    }

    public static void main(String[] args) {
        Queue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(40);
        queue.print();
        System.out.println("Deque: " + queue.dequeue());
        System.out.println("Deque: " + queue.dequeue());
        System.out.println("Deque: " + queue.dequeue());
        System.out.println("Deque: " + queue.dequeue());
    }
}
