package com.thomasgassmann.datastructures;

public interface IQueue<T> {
    T dequeue();
    T front();
    void enqueue(T item);
    boolean isEmpty();
}
