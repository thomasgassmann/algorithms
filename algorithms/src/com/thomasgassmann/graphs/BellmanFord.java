package com.thomasgassmann.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BellmanFord {
    public static ArrayList<Integer> BellmanFord(GraphWithWeights<Integer> g, int from, int to) {
        var d = new HashMap<Integer, Integer>();
        var p = new HashMap<Integer, Integer>();
        d.put(from, 0);

        for (int i = 1; i < g.getVertices().size(); i++) {
            // for all edges
            for (var u : g.getVertices()) {
                for (var v : g.getAdjacent(u)) {
                    var vd = d.getOrDefault(v.value, Integer.MAX_VALUE);
                    if (vd > d.get(u) + v.weight) {
                        d.put(v.value, d.get(u) + v.weight);
                        p.put(v.value, u);
                    }
                }
            }
        }

        for (var u : g.getVertices()) {
            for (var v : g.getAdjacent(u)) {
                if (d.get(v.value) > d.get(u) + v.weight) {
                    // There exists a cycle with negative weights
                    return null;
                }
            }
        }

        var res = new ArrayList<Integer>();
        res.add(to);
        var c = to;
        while (p.containsKey(c)) {
            c = p.get(c);
            res.add(0, c);
        }

        return res;
    }
}
