package com.css.gfg.tree;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }
}
