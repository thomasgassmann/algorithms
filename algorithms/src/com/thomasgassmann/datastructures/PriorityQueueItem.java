package com.thomasgassmann.datastructures;

public class PriorityQueueItem<T> {
    public PriorityQueueItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public int priority;
    public T item;
}
