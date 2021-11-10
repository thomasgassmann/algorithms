package com.thomasgassmann.datastructures;

public interface ProbingProvider {
    void init(HashProvider hashing);
    int probe(int j, int k);
}
