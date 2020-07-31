package com.css.gfg.queue;

/**
 * DeQueue - Double Ended Queue
 * In DeQueue enqueue, dequeue can be performed from both the sides (front, rear).
 * There are 2 types of DeQueue
 *  1. Input restricted queue
 *  2. Output restricted queue
 *
 *  1. Input restricted queue  - In this enqueue operation can be performed from only one end, but dequeue can be performed from both the sides.
 *  2. Output restricted queue - In this dequeue operation can be performed from only one end, but enqueue can be performed from both the sides.
 *
 */
public class Dequeue {

    int dequeue[];
    int size;
    int front = -1;
    int rear = -1;

    public Dequeue(int size) {
        this.size = size;
        dequeue = new int[size];
    }

    public void enqueueFront(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is Full...!");
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }
        dequeue[front] = data;
    }

    public void enqueueRear(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is Full...!");
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        dequeue[rear] = data;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty...!");
        }
        int data = dequeue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return data;
    }

    public int dequeueRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty...!");
        }
        int data = dequeue[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        }else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        return data;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean isFull() {
        //return (front == 0 && rear == size-1) || (front == rear+1);
        return front == ((rear + 1) % size);
    }

    public int getFront() {
        return get(front);
    }

    public int getRear() {
        return get(rear);
    }

    public int get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty...!");
        }
        return dequeue[index];
    }

    public void display() {
        int i = front;
        while (i != rear) {
            System.out.print(dequeue[i] + " ");
            i = (i+1)%size;
        }
        System.out.println(dequeue[rear]);
        System.out.println();
    }

    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue(5);
        dequeue.enqueueFront(2);
        dequeue.enqueueFront(5);
        dequeue.enqueueRear(-1);

        dequeue.enqueueRear(0);
        dequeue.enqueueFront(7);
        dequeue.display();
        dequeue.dequeueRear();
        dequeue.dequeueRear();
        dequeue.dequeueRear();
        dequeue.display();
    }
}
