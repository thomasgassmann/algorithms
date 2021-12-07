package com.thomasgassmann.exercises;

import com.thomasgassmann.datastructures.Stack;
import com.thomasgassmann.graphs.Graph;
import com.thomasgassmann.graphs.Node;

import java.util.HashSet;

public class DrivingOnHighways {
    public static boolean drivingOnHighways(Graph graph) {
        // topological order
        var stack = new Stack<Node>();
        dfsTopologicalOrder(graph, stack);

        // transpose graph
        var transpose = transposeGraph(graph);

        var markings = new HashSet<Node>();
        dfsCheck(transpose, stack.pop(), markings);
        while (markings.contains(stack.top())) {
            stack.pop();
        }

        return stack.isEmpty();
    }

    private static void dfsCheck(Graph graph, Node v, HashSet<Node> markings) {
        markings.add(v);
        for (var u : graph.getAdjacent(v)) {
            if (!markings.contains(u)) {
                dfsCheck(graph, u, markings);
            }
        }
    }

    private static Graph transposeGraph(Graph graph) {
        var transpose = new Graph();
        transpose.vertices.addAll(graph.vertices);

        for (var edge : graph.edges) {
            transpose.addDirectedEdge(
                    transpose.getVertex(edge.to.name),
                    transpose.getVertex(edge.from.name));
        }

        return transpose;
    }

    private static void dfsTopologicalOrder(Graph graph, Stack<Node> stack) {
        var markings = new HashSet<Node>();
        for (var vertex : graph.vertices) {
            if (!markings.contains(vertex)) {
                dfsVisitTopologicalOrder(graph, vertex, markings, stack);
            }
        }
    }

    private static void dfsVisitTopologicalOrder(Graph graph, Node u, HashSet<Node> markings, Stack<Node> stack) {
        markings.add(u);
        for (var adj : graph.getAdjacent(u)) {
            if (!markings.contains(adj)) {
                dfsVisitTopologicalOrder(graph, adj, markings, stack);
            }
        }

        stack.push(u);
    }
}
