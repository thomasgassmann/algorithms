package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MST {
    public static <T> ArrayList<EdgeWithWeights<T>> Prim(GraphWithWeights<T> graph) {
        var q = new PriorityQueue<EdgeWithWeights<T>>();
        var mst = new ArrayList<EdgeWithWeights<T>>(graph.getVertices().size() - 1);
        var start = graph.getAnyVertex();
        for (var c : graph.getAdjacent(start)) {
            q.enqueue(new EdgeWithWeights<>(start, c.value, c.weight), c.weight);
        }

        var vertices = new HashSet<T>();
        vertices.add(start);
        while (!q.isEmpty()) {
            var v = q.dequeue();
            if (!vertices.contains(v.to) && vertices.contains(v.from)) {
                vertices.add(v.to);
                for (var w : graph.getAdjacent(v.to)) {
                    q.enqueue(new EdgeWithWeights<>(v.to, w.value, w.weight), w.weight);
                }

                mst.add(v);
            }
        }

        return mst;
    }

    public static <T> ArrayList<EdgeWithWeights<T>> Boruvka(GraphWithWeights<T> graph) {
        var uf = UnionFind.<T>make(graph);

        var mst = new ArrayList<EdgeWithWeights<T>>();

        // repeat at most log V times or until we have V-1 edges
        for (int t = 1; t < graph.getVertices().size() && mst.size() < graph.getVertices().size() - 1; t = t + t) {

            // foreach tree in forest, find closest edge
            // if edge weights are equal, ties are broken in favor of first edge in G.edges()
            HashMap<T, EdgeWithWeights<T>> closest = new HashMap<T, EdgeWithWeights<T>>(graph.getVertices().size());
            for (var v : graph.getVertices()) {
                for (var w : graph.getAdjacent(v)) {
                    T i = uf.repr(v);
                    T j = uf.repr(w.value);
                    if (i == j) {
                        continue;   // same tree
                    }

                    if (!closest.containsKey(i) || w.weight < closest.get(i).weight) {
                        closest.put(i, new EdgeWithWeights<T>(v, w.value, w.weight));
                    }

                    if (!closest.containsKey(j) || w.weight < closest.get(j).weight) {
                        closest.put(j, new EdgeWithWeights<T>(v, w.value, w.weight));
                    }
                }
            }

            // add newly discovered edges to MST
            for (var i : graph.getVertices()) {
                var e = closest.get(i);
                if (e != null) {
                    T v = e.from, w = e.to;
                    // don't add the same edge twice
                    if (!uf.same(v, w)) {
                        mst.add(e);
                        uf.union(v, w);
                    }
                }
            }
        }

        return mst;
    }
}
