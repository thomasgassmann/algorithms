package com.thomasgassmann.datastructures;

public class LinearProbing implements ProbingProvider {
    @Override
    public void init(HashProvider hashing) {
    }

    @Override
    public int probe(int j, int k) {
        return j;
    }
}
