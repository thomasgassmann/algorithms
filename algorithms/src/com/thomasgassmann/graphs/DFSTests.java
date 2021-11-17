package com.thomasgassmann.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFSTests {
    @Test
    public void checkDFS() {
        var g = new GraphAdjacencyList(5);
        g.addUndirected(0, 1);
        g.addUndirected(0, 2);
        g.addUndirected(2, 3);
        g.addUndirected(3, 4);

        var res = DFS.DFS(g);

        for (int i = 0; i < 5; i++) {
            Assertions.assertTrue(res.contains(i));
        }
    }
}
