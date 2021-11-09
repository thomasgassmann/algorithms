package com.thomasgassmann.datastructures;

public class Stack<T> implements IStack<T> {
    private StackItem<T> p;

    @Override
    public void push(T x) {
        p = new StackItem<T>(p, x);
    }

    @Override
    public T pop() {
        if (p == null)
            return null;
        StackItem<T> current = p;
        p = current.previous;
        return current.item;
    }

    @Override
    public T top() {
        return p.item;
    }

    @Override
    public boolean isEmpty() {
        return p == null;
    }

    public static <E> Stack<E> newStack() {
        return new Stack<E>();
    }
}
