package com.thomasgassmann.graphs;

import com.thomasgassmann.AssertionHelpers;
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
    public void assertTopologicalSortDFS() {
        // Arrange
        var graph = new GraphAdjacencyList(8);
        graph.addDirected(0, 1); // A -> B
        graph.addDirected(0, 2); // A -> C
        graph.addDirected(2, 3); // C -> D
        graph.addDirected(3, 7); // D -> H
        graph.addDirected(0, 5); // A -> F
        graph.addDirected(1, 4); // B -> E
        graph.addDirected(4, 5); // E -> F
        graph.addDirected(5, 6); // F -> G
        graph.addDirected(6, 7); // G -> H
        graph.addDirected(4, 6); // E -> G

        // Act
        var sort = TopologicalSort.TopologicalSortForGraphsWithoutCycles(graph);

        // Assert
        AssertionHelpers.AssertEqual(new int[] { 7, 6, 5, 4, 1, 3, 2, 0 }, sort.stream().mapToInt(p -> p).toArray());
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
