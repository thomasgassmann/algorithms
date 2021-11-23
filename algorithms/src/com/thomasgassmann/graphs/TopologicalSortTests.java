package com.thomasgassmann.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopologicalSortTests {
    @Test
    public void checkCycleNoTopologicalSort() {
        // Arrange
        var graph = new Graph();
        var a = graph.addVertex("a");
        var b = graph.addVertex("b");
        var c = graph.addVertex("c");
        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(b, c);
        graph.addDirectedEdge(c, a);

        // Act
        var res = TopologicalSort.TopologicalSort(graph);

        // Assert
        Assertions.assertEquals(null, res);
    }

    @Test
    public void assertTopologicalSort() {
        // Arrange
        var graph = new Graph();
        var a = graph.addVertex("a");
        var b = graph.addVertex("b");
        var c = graph.addVertex("c");
        var d = graph.addVertex("d");
        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(b, c);
        graph.addDirectedEdge(c, d);
        graph.addDirectedEdge(a, d);

        // Act
        var sort = TopologicalSort.TopologicalSort(graph);

        // Assert
        Assertions.assertEquals(4, sort.get(d));
        Assertions.assertEquals(3, sort.get(c));
        Assertions.assertEquals(2, sort.get(b));
        Assertions.assertEquals(1, sort.get(a));
    }
}
