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
public class ArrayCircularQueue implements Queue<Integer> {
    private int size;
    private int[] queue;
    private int front;
    private int rear;

    public ArrayCircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public ArrayCircularQueue(int a[]) {
        this(a.length);
        for (int data : a) {
            this.enqueue(data);
        }
    }


    public void enqueue(Integer data) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full...!");
        }
        if (rear == size-1 && front > 0) {
            rear = -1;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        queue[rear]=data;
    }

    public Integer dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty...!");
        }
        int data = queue[front];
        if (front == size-1) {
            front = 0;
        } else if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return data;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean isFull() {
        return (front == 0 && rear == size-1) || (rear == front-1);
        //return (rear+1)%size == front;
    }

    public void delete() {
        queue = null;
    }

    public int size() {
        return isEmpty()? 0 : (rear+1 - front);
    }

    public void print() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty...!");
        }
        if (rear>=front) {
            for (int i=front; i<=rear; i++) {
                System.out.print(queue[i]+ " ");
            }
        } else {
            for (int i=front; i<size; i++) {
                System.out.print(queue[i]+ " ");
            }
            for (int i=0; i<=rear; i++) {
                System.out.print(queue[i]+ " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new ArrayCircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.enqueue(8);
        queue.print();
        queue.enqueue(9);
        queue.print();
        queue.enqueue(10);
    }
}
