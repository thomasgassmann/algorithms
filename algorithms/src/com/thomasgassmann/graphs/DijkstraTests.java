package com.thomasgassmann.graphs;

import com.thomasgassmann.AssertionHelpers;
import org.junit.jupiter.api.Test;

public class DijkstraTests {
    @Test
    public void checkShortestPath() {
        var graph = new GraphWithWeights<Integer>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addDirectedEdge(1, 4, 2);
        graph.addDirectedEdge(1, 2, 5);
        graph.addDirectedEdge(1, 3, 3);
        graph.addDirectedEdge(4, 7, 8);
        graph.addDirectedEdge(4, 3, 2);
        graph.addDirectedEdge(3, 2, 1);
        graph.addDirectedEdge(3, 5, 3);
        graph.addDirectedEdge(2, 5, 3);
        graph.addDirectedEdge(7, 3, 1);
        graph.addDirectedEdge(5, 7, 3);
        graph.addDirectedEdge(5, 6, 1);
        graph.addDirectedEdge(6, 7, 1);

        var path = Dijkstra.Dijkstra(graph, 1, 7);

        AssertionHelpers.AssertEqual(
                new int[] { 1, 3, 5, 6, 7 },
                path.stream().mapToInt(p -> p).toArray());
    }
}
