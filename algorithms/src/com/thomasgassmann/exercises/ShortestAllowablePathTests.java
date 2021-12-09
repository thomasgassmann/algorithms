package com.thomasgassmann.exercises;

import com.thomasgassmann.graphs.GraphWithWeights;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ShortestAllowablePathTests {
    @Test
    public void checkShortestAllowablePath() {
        var g = new GraphWithWeights<Integer>();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);

        g.addDirectedEdge(0, 1, 15);
        g.addDirectedEdge(0, 3, 0);
        g.addDirectedEdge(1, 2, 10);
        g.addDirectedEdge(3, 4, 1);
        g.addDirectedEdge(2, 5, 5);
        g.addDirectedEdge(4, 5, 2);
        g.addDirectedEdge(5, 6, 3);

        var green = new HashMap<Integer, Boolean>();
        green.put(0, true);
        green.put(1, true);
        green.put(2, true);
        green.put(3, false);
        green.put(4, true);
        green.put(5, false);
        green.put(6, true);

        var r = ShortestAllowablePath.ShortestAllowablePath(g, green, 0);

        Assertions.assertEquals(r.get(0), 0);
        Assertions.assertEquals(r.get(1), 15);
        Assertions.assertEquals(r.get(2), 25);
        Assertions.assertEquals(r.get(3), 0);
        Assertions.assertEquals(r.get(4), 1);
        Assertions.assertEquals(r.get(5), 30);
        Assertions.assertEquals(r.get(6), 33);
    }
}
