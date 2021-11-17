package com.thomasgassmann.graphs;

import java.util.HashSet;

public class DFS {
    public static HashSet<Integer> DFS(GraphAdjacencyList g) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int v : g.getAll()) {
            if (!visited.contains(v)) {
                DFSVisit(g, v, visited);
            }
        }

        return visited;
    }

    private static void DFSVisit(GraphAdjacencyList g, int v, HashSet<Integer> visited) {
        visited.add(v);
        for (int e : g.getAdjacent(v)) {
            if (!visited.contains(e)) {
                DFSVisit(g, e, visited);
            }
        }
    }
}
