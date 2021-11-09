package com.thomasgassmann.datastructures;

public class StackItem<T> {
    public StackItem(StackItem prev, T item) {
        previous = prev;
        this.item = item;
    }

    public StackItem previous;
    public T item;
}
