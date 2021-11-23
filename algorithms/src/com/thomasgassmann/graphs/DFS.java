package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.Stack;

import java.util.HashSet;

public class DFS {
    public static HashSet<Integer> DFSIterative(GraphAdjacencyList g) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int v : g.getVertices()) {
            if (!visited.contains(v)) {
                DFSVisitIterative(g, v, visited);
            }
        }

        return visited;
    }

    public static HashSet<Integer> DFS(GraphAdjacencyList g) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int v : g.getVertices()) {
            if (!visited.contains(v)) {
                DFSVisit(g, v, visited);
            }
        }

        return visited;
    }

    private static void DFSVisitIterative(GraphAdjacencyList g, int v, HashSet<Integer> visited) {
        var stack = new Stack<Integer>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int w = stack.pop();
            if (!visited.contains(w)) {
                visited.add(w);
                for (int x : g.getAdjacent(w)) {
                    if (!visited.contains(x)) {
                        stack.push(x);
                    }
                }
            }
        }
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
