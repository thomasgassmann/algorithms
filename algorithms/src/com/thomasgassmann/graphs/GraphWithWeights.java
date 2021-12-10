package com.thomasgassmann.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GraphWithWeights<T> {
    private HashMap<T, ArrayList<NodeWithWeight<T>>> adjecency = new HashMap<>();

    public T getAnyVertex() {
        if (adjecency.keySet().size() == 0) {
            return null;
        }

        return adjecency.keySet().iterator().next();
    }

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

    public void addUndirectedEdge(T from, T to, int weight) {
        addDirectedEdge(from, to, weight);
        addDirectedEdge(to, from, weight);
    }

    public int getWeight(T from, T to) {
        var e = adjecency.get(from).stream().filter(p -> p.value == to).findFirst();
        if (!e.isPresent()) {
            throw new IllegalArgumentException();
        }

        return e.get().weight;
    }

    public boolean hasEdge(T from, T to) {
        return adjecency.get(from).stream().anyMatch(p -> p.value == to);
    }
}
