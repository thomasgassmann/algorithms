package com.thomasgassmann.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BFSPathTests {
    @Test
    public void checkPath() {
        var graph = new Graph();
        var a = graph.addVertex("A");
        var b = graph.addVertex("B");
        var c = graph.addVertex("C");
        var d = graph.addVertex("D");
        var e = graph.addVertex("E");
        var f = graph.addVertex("F");
        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(b, c);
        graph.addDirectedEdge(c, e);
        graph.addDirectedEdge(e, f);
        graph.addDirectedEdge(b, d);
        graph.addDirectedEdge(d, f);

        var path = BFSPath.BFSPath(graph, a, f);

        Assertions.assertEquals(4, path.size());
        Assertions.assertEquals("A", path.get(0).name);
        Assertions.assertEquals("B", path.get(1).name);
        Assertions.assertEquals("D", path.get(2).name);
        Assertions.assertEquals("F", path.get(3).name);
    }
}
