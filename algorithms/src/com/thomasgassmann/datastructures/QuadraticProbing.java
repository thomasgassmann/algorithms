package com.thomasgassmann.datastructures;

public class QuadraticProbing implements ProbingProvider {
    @Override
    public void init(HashProvider hashing) {
    }

    @Override
    public int probe(int j, int k) {
        return (int)Math.pow(Math.ceil(j / 2), 2D) * (int)Math.pow(-1, j + 1);
    }
}
