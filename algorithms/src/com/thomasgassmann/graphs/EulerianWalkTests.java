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
        graph.nodes.add(a);
        graph.nodes.add(b);
        graph.nodes.add(c);
        graph.nodes.add(d);
        graph.nodes.add(e);
        graph.nodes.add(f);
        graph.nodes.add(g);
        graph.nodes.add(h);
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
