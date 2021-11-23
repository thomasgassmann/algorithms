package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TopologicalSort {
    // script (more general)
    public static HashMap<Node, Integer> TopologicalSort(Graph graph) {
        var stack = new Stack<Node>();
        var A = new HashMap<Node, Integer>();
        for (int i = 0; i < graph.vertices.size(); i++)
            A.put(graph.vertices.get(i), 0);
        for (int i = 0; i < graph.edges.size(); i++)
            A.put(graph.edges.get(i).to, A.get(graph.edges.get(i).to) + 1);
        for (int i = 0; i < graph.vertices.size(); i++)
            if (A.get(graph.vertices.get(i)) == 0)
                stack.push(graph.vertices.get(i));
        int i = 1;
        HashMap<Node, Integer> ord = new HashMap<>();
        while (!stack.isEmpty()) {
            Node v = stack.pop();
            ord.put(v, i++);
            for (int j = 0; j < graph.edges.size(); j++) {
                Edge edge = graph.edges.get(j);
                if (edge.from == v) {
                    A.put(edge.to, A.get(edge.to) - 1);
                    if (A.get(edge.to) == 0)
                        stack.push(edge.to);
                }
            }
        }

        if (i == graph.vertices.size() + 1)
            return ord;

        return null;
    }

    // lecture
    public static ArrayList<Integer> TopologicalSortForGraphsWithoutCycles(GraphAdjacencyList graph) {
        var res = new ArrayList<Integer>();
        var markings = new HashSet<Integer>();
        for (var vertex : graph.getVertices()) {
            if (!markings.contains(vertex)) {
                visit(graph, markings, res, vertex);
            }
        }

        return res;
    }

    private static void visit(GraphAdjacencyList graph, HashSet<Integer> markings, ArrayList<Integer> res, int vertex) {
        markings.add(vertex);
        for (var v : graph.getAdjacent(vertex)) {
            if (!markings.contains(v)) {
                visit(graph, markings, res, v);
            }
        }

        res.add(vertex);
    }
}
