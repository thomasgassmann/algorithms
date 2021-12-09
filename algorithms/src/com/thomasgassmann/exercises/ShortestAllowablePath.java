package com.thomasgassmann.exercises;

import com.thomasgassmann.graphs.GraphWithWeights;

import java.util.HashMap;

public class ShortestAllowablePath {
    public static HashMap<Integer, Integer> ShortestAllowablePath(GraphWithWeights<Integer> g, HashMap<Integer, Boolean> isGreen, Integer s) {
        var ng = new GraphWithWeights<Integer>();
        for (var v : g.getVertices()) {
            ng.addVertex(mapIndexV0(v));
            ng.addVertex(mapIndexV1(v));
        }

        for (var u : g.getVertices()) {
            for (var v : g.getAdjacent(u)) {
                if (isGreen.get(u) && isGreen.get(v.value)) {
                    ng.addDirectedEdge(mapIndexV0(u), mapIndexV0(v.value), v.weight);
                    ng.addDirectedEdge(mapIndexV1(u), mapIndexV1(v.value), v.weight);
                }

                if (isGreen.get(u) && !isGreen.get(v.value)) {
                    ng.addDirectedEdge(mapIndexV0(u), mapIndexV1(v.value), v.weight);
                }

                if (!isGreen.get(u) && isGreen.get(v.value)) {
                    ng.addDirectedEdge(mapIndexV1(u), mapIndexV1(v.value), v.weight);
                }
            }
        }

        HashMap<Integer, Integer> bd = isGreen.get(s)
                ? BellmanFord(ng, mapIndexV0(s))
                : BellmanFord(ng, mapIndexV1(s));
        var d = new HashMap<Integer, Integer>();
        for (var v : g.getVertices()) {
            d.put(v, Math.min(bd.get(mapIndexV0(v)), bd.get(mapIndexV1(v))));
        }

        return d;
    }

    private static HashMap<Integer, Integer> BellmanFord(GraphWithWeights<Integer> g, Integer s) {
        var d = new HashMap<Integer, Integer>();
        for (var v : g.getVertices()) {
            d.put(v, Integer.MAX_VALUE - 500); // this is so ugly
        }

        d.put(s, 0);
        for (int i = 0; i < g.getVertices().size() - 1; i++) {
            for (var u : g.getVertices()) {
                for (var v : g.getAdjacent(u)) {
                    if (d.get(v.value) > d.get(u) + v.weight) {
                        d.put(v.value, d.get(u) + v.weight);
                    }
                }
            }
        }

        return d;
    }

    private static int mapIndexV0(int i) {
        return i * 10;
    }

    private static int mapIndexV1(int i) {
        return i * 10 + 1;
    }
}
