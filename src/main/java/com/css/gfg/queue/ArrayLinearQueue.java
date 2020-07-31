package com.css.gfg.queue;

/**
 * This is fixed array based implementation of the queue.
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
public class ArrayLinearQueue implements Queue<Integer> {

    private int size;
    private int[] queue;
    private int rear;
    private int front;

    public ArrayLinearQueue(int size) {
        this.size = size;
        queue = new int[size];
        this.rear = -1;
        this.front = -1;
    }

    public void enqueue(Integer data) {
        //check if the queue is full
        if (isFull()) {
            System.out.println("This Queue is Full...!");
            throw new IllegalStateException("Queue is Full...!");
        }
        if (isEmpty()) {
            front++;
        }
        rear++;
        queue[rear] = data;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("This Queue is Empty...!");
            throw new IllegalStateException("Queue is Empty...!");
        }
        int data = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == -1 || front == size-1;
    }

    public boolean isFull() {
        return rear == (size-1);
    }

    public void delete() {
        queue = null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("This Queue is Empty...!");
            return;
        }

        int start = front;
        while (start != size && start <= rear) {
            System.out.print(queue[start] + " ");
            start++;
        }
        System.out.println();
    }

    public int size() {
        return isEmpty()? 0 : (rear+1 - front);
    }

    public static void main(String[] args) {
        Queue queue = new ArrayLinearQueue(5);
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
