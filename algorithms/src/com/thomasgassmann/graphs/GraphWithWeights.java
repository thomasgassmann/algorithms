package com.thomasgassmann.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GraphWithWeights<T> {
    private HashMap<T, ArrayList<NodeWithWeight<T>>> adjecency = new HashMap<>();

    public Collection<T> getVertices() {
        return adjecency.keySet();
    }

    public Collection<NodeWithWeight<T>> getAdjacent(T i) {
        return adjecency.get(i);
    }

    public void addVertex(T i) {
        adjecency.put(i, new ArrayList<>());
    }

    public void addDirectedEdge(T from, T to, int weight) {
        adjecency.get(from).add(new NodeWithWeight<>(to, weight));
    }
}
