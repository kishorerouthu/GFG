package com.css.gfg.queue;

public interface Queue<T> {
    void enqueue(T data);
    T dequeue();
    boolean isEmpty();
    boolean isFull();
    void delete();
    void print();
    int size();
    T front();
    T rear();
}
