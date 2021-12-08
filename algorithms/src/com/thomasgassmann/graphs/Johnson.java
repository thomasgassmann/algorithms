package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.PriorityQueue;

import java.util.HashMap;

public class Johnson {
    public static HashMap<Integer, HashMap<Integer, Integer>> Johnson(GraphWithWeights<Integer> graph) {
        final int NEW_VERTEX = -1;
        graph.addVertex(NEW_VERTEX);

        // add edge from new to v for every v in V\{new}
        for (var u : graph.getVertices()) {
            if (u != NEW_VERTEX) {
                graph.addDirectedEdge(NEW_VERTEX, u, 0);
            }
        }

        // run Bellman-Ford
        var d = new HashMap<Integer, Integer>();
        d.put(NEW_VERTEX, 0);
        for (int i = 0; i < graph.getVertices().size() - 1; i++) {
            for (var u : graph.getVertices()) {
                for (var v : graph.getAdjacent(u)) {
                    var vd = d.getOrDefault(v.value, Integer.MAX_VALUE);
                    if (d.containsKey(u) && vd > d.get(u) + v.weight) {
                        d.put(v.value, d.get(u) + v.weight);
                    }
                }
            }
        }

        // check for negative cycle
        for (var u : graph.getVertices()) {
            for (var v : graph.getAdjacent(u)) {
                if (d.get(v.value) > d.get(u) + v.weight) {
                    return null;
                }
            }
        }

        // calculate new weights
        for (var u : graph.getVertices()) {
            for (var v : graph.getAdjacent(u)) {
                v.weight = v.weight + d.get(u) - d.get(v.value);
            }
        }

        // run Dijkstra for each vertex v
        var res = new HashMap<Integer, HashMap<Integer, Integer>>();
        for (var v : graph.getVertices()) {
            var cd = new HashMap<Integer, Integer>();
            res.put(v, cd);

            var q = new PriorityQueue<Integer>();
            cd.put(v, 0);
            q.enqueue(v, 0);
            while (!q.isEmpty()) {
                var u = q.dequeue();
                for (var w : graph.getAdjacent(u)) {
                    var distance = cd.get(u) + w.weight;
                    if (!cd.containsKey(w.value)) {
                        q.enqueue(w.value, distance);
                        cd.put(w.value, distance);
                    } else if (cd.get(w.value) > distance) {
                        q.decreaseKey(w.value, distance);
                        cd.put(w.value, distance);
                    }
                }
            }

            // remove updated weights
            for (var key : cd.keySet()) {
                cd.put(key, cd.get(key) - (d.get(v) - d.get(key)));
            }
        }

        return res;
    }
}
