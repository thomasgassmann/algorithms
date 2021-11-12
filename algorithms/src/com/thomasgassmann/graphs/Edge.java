package com.thomasgassmann.graphs;

public class Edge {
    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node from;
    public Node to;

    @Override
    public int hashCode() {
        return (from.name + to.name).hashCode();
    }
}
