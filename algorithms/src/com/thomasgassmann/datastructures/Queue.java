package com.thomasgassmann.datastructures;

public class Queue<T> implements IQueue<T> {
    private StackItem<T> start;
    private StackItem<T> end;

    @Override
    public T dequeue() {
        if (end == null)
            return null;
        StackItem<T> currentEnd = end;
        end = end.previous;
        if (end == null)
            start = null;
        return currentEnd.item;
    }

    @Override
    public T front() {
        if (end == null)
            return null;
        return end.item;
    }

    @Override
    public void enqueue(T item) {
        var newItem = new StackItem(null, item);;
        if (start != null) {
            start.previous = newItem;
        } else {
            end = newItem;
        }

        start = newItem;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }
}
