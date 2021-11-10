package com.thomasgassmann.datastructures;

public class DoubleHashing implements ProbingProvider {
    private HashProvider _second;

    public DoubleHashing(HashProvider second) {
        _second = second;
    }

    @Override
    public void init(HashProvider hashing) {
    }

    @Override
    public int probe(int j, int k) {
        return j * _second.hash(k);
    }
}
