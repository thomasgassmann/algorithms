package com.thomasgassmann.graphs;

import java.util.ArrayList;

public class GraphAdjacencyList {
    private ArrayList<Integer>[] _nodes;

    public GraphAdjacencyList(int capacity) {
        _nodes = new ArrayList[capacity];

        for (int i = 0; i < _nodes.length; i++) {
            _nodes[i] = new ArrayList<>();
        }
    }

    public int[] getAll() {
        int[] a = new int[_nodes.length];
        for (int i = 0; i < _nodes.length; i++) {
            a[i] = i;
        }

        return a;
    }

    public int[] getAdjacent(int a) {
        return _nodes[a].stream().mapToInt(p -> p).toArray();
    }

    public void addUndirected(int a, int b) {
        _nodes[a].add(b);
        _nodes[b].add(a);
    }
}
