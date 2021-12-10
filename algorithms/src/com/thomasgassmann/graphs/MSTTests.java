package com.thomasgassmann.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MSTTests {
    @Test
    public void checkKruksal() {
        var g = getExampleGraph();
        var r = MST.Kruksal(g);

        assertMst(r);
    }

    @Test
    public void checkBoruvka() {
        var g = getExampleGraph();
        var r = MST.Boruvka(g);

        assertMst(r);
    }

    @Test
    public void checkPrim() {
        var g = getExampleGraph();
        var r = MST.Prim(g);

        assertMst(r);
    }

    private void assertMst(ArrayList<EdgeWithWeights<Integer>> mst) {
        Assertions.assertEquals(6, mst.size());
        Assertions.assertTrue(mst.stream().anyMatch(match(2, 1, 3)));
        Assertions.assertTrue(mst.stream().anyMatch(match(5, 1, 2)));
        Assertions.assertTrue(mst.stream().anyMatch(match(3, 2, 4)));
        Assertions.assertTrue(mst.stream().anyMatch(match(9, 4, 5)));
        Assertions.assertTrue(mst.stream().anyMatch(match(1, 5, 7)));
        Assertions.assertTrue(mst.stream().anyMatch(match(6, 6, 7)));
    }

    private Predicate<EdgeWithWeights<Integer>> match(int weight, int from, int to) {
        return p -> p.weight == weight &&
                ((p.from == from && p.to == to) || (p.to == from && p.from == to));
    }

    private GraphWithWeights<Integer> getExampleGraph() {
        var g = new GraphWithWeights<Integer>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addUndirectedEdge(1, 2, 5);
        g.addUndirectedEdge(1, 3, 2);
        g.addUndirectedEdge(2, 4, 3);
        g.addUndirectedEdge(3, 4, 7);
        g.addUndirectedEdge(4, 5, 9);
        g.addUndirectedEdge(4, 6, 11);
        g.addUndirectedEdge(5, 7, 1);
        g.addUndirectedEdge(6, 7, 6);
        return g;
    }
}
