package com.thomasgassmann.datastructures;

public class ArrayStack<T> implements IStack<T> {
    private T[] values;
    private int currentIndex;

    public ArrayStack(int i) {
        values = (T[])new Object[i];
        currentIndex = 0;
    }

    @Override
    public void push(T t) {
        values[currentIndex++] = t;
    }

    @Override
    public T pop() {
        return values[currentIndex-- - 1];
    }

    @Override
    public T top() {
        return values[currentIndex - 1];
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }
}
