package com.thomasgassmann.datastructures;

public interface IStack<T> {
    void push(T t);
    T pop();
    T top();
    boolean isEmpty();
}
