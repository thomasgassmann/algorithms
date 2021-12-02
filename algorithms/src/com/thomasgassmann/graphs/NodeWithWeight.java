package com.thomasgassmann.graphs;

public class NodeWithWeight<T> {
    public NodeWithWeight(T val, int weight) {
        value = val;
        this.weight = weight;
    }

    public T value;
    public int weight;
}
