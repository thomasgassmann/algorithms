package com.thomasgassmann.graphs;

public class EdgeWithWeights<T> {
    public EdgeWithWeights(T from, T to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public T from;
    public T to;
    public int weight;
}
