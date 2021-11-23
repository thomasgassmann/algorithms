package com.thomasgassmann.graphs;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<Node> vertices = new ArrayList<>();

    public Node addVertex(String name) {
        var node = new Node(name);
        vertices.add(node);
        return node;
    }

    public void addDirectedEdge(Node u, Node v) {
        edges.add(new Edge(u, v));
    }
}
