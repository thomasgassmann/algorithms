package com.thomasgassmann.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<Node> vertices = new ArrayList<>();

    public List<Node> getAdjacent(Node v) {
        return edges.stream().filter(p -> p.from.name == v.name).map(p -> p.to).toList();
    }

    public Node getVertex(String name) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).name == name) {
                return vertices.get(i);
            }
        }

        return null;
    }

    public Node addVertex(String name) {
        var node = new Node(name);
        vertices.add(node);
        return node;
    }

    public void addDirectedEdge(Node u, Node v) {
        edges.add(new Edge(u, v));
    }
}
