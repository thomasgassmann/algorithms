package com.thomasgassmann.graphs;

import com.thomasgassmann.AssertionHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FloydWarshallTests {
    @Test
    public void checkForNegativeCycle() {
        var graph = new GraphWithWeights<Integer>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addDirectedEdge(0, 1, -1);
        graph.addDirectedEdge(1, 2, 2);
        graph.addDirectedEdge(2, 0, -2);

        var res = FloydWarshall.FloydWarshall(graph);

        Assertions.assertNull(res);
    }

    @Test
    public void checkFloydWarshall() {
        var graph = new GraphWithWeights<Integer>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addDirectedEdge(0, 3, 1);
        graph.addDirectedEdge(0, 1, 4);
        graph.addDirectedEdge(0, 2, 2);
        graph.addDirectedEdge(3, 6, 8);
        graph.addDirectedEdge(3, 2, 1);
        graph.addDirectedEdge(2, 1, 0);
        graph.addDirectedEdge(2, 4, 2);
        graph.addDirectedEdge(1, 4, 2);
        graph.addDirectedEdge(6, 2, 0);
        graph.addDirectedEdge(4, 6, 2);
        graph.addDirectedEdge(4, 5, 0);
        graph.addDirectedEdge(5, 6, 0);

        var succ = FloydWarshall.FloydWarshall(graph);

        final var FROM = 0;
        final var TO = 6;
        var u = FROM;
        var res = new int[5];
        int i = 0;
        res[i++] = u;
        while (u != TO) {
            u = succ[u][TO];
            res[i++] = u;
        }

        AssertionHelpers.AssertEqual(
                new int[] { 0, 2, 4, 5, 6 },
                res
        );
    }
}
