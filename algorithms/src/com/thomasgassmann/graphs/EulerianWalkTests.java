package com.thomasgassmann.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EulerianWalkTests {
    @Test
    public void CheckEulerianWalk() {
        var graph = new Graph();
        var a = new Node("A");
        var b = new Node("B");
        var c = new Node("C");
        var d = new Node("D");
        var e = new Node("E");
        var f = new Node("F");
        var g = new Node("G");
        var h = new Node("H");
        graph.vertices.add(a);
        graph.vertices.add(b);
        graph.vertices.add(c);
        graph.vertices.add(d);
        graph.vertices.add(e);
        graph.vertices.add(f);
        graph.vertices.add(g);
        graph.vertices.add(h);
        graph.edges.add(new Edge(a, b));
        graph.edges.add(new Edge(b, c));
        graph.edges.add(new Edge(a, c));
        graph.edges.add(new Edge(b, d));
        graph.edges.add(new Edge(b, f));
        graph.edges.add(new Edge(f, e));
        graph.edges.add(new Edge(d, e));
        graph.edges.add(new Edge(e, g));
        graph.edges.add(new Edge(e, h));
        graph.edges.add(new Edge(h, g));

        var res = EulerianWalk.EulerianWalk(graph);
        Assertions.assertEquals(11, res.size());
    }
}
