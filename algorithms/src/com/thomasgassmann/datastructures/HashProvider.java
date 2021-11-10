package com.thomasgassmann.datastructures;

public interface HashProvider {
    void init(int size);
    int hash(int key);
}
