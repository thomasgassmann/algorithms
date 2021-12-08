package com.thomasgassmann.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JohnsonTests {
    @Test
    public void checkJohnson() {
        var graph = new GraphWithWeights<Integer>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addDirectedEdge(0, 3, 1);
        graph.addDirectedEdge(0, 1, -4);
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

        var r = Johnson.Johnson(graph);

        Assertions.assertEquals(-4, r.get(0).get(1));
        Assertions.assertEquals(2, r.get(2).get(6));
        Assertions.assertEquals(3, r.get(3).get(4));
        Assertions.assertEquals(3, r.get(3).get(5));
        Assertions.assertTrue(!r.get(3).containsKey(0));
        Assertions.assertEquals(-2, r.get(0).get(5));
    }

    @Test
    public void checkGraphWithNegativeCycleIsRejected() {
        var g = new GraphWithWeights<Integer>();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addDirectedEdge(0, 1, 2);
        g.addDirectedEdge(1, 2, 5);
        g.addDirectedEdge(2, 3, 4);
        g.addDirectedEdge(3, 1, -20);

        var r = Johnson.Johnson(g);

        Assertions.assertNull(r);
    }
}
