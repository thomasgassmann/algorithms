package com.thomasgassmann.datastructures;

public class BasicHashProvider implements HashProvider {
    private int _m;

    @Override
    public void init(int size) {
        _m = size;
    }

    @Override
    public int hash(int key) {
        return key % _m;
    }
}
