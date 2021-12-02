package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
    public static ArrayList<Integer> Dijkstra(GraphWithWeights<Integer> graph, int from, int to) {
        var n = graph.getVertices().size();

        var dist = new HashMap<Integer, Integer>();
        dist.put(from, 0);

        var p = new HashMap<Integer, Integer>();

        var q = new PriorityQueue<Integer>();
        q.enqueue(from, 0);
        while (!q.isEmpty()) {
            var u = q.dequeue();
            for (var v : graph.getAdjacent(u)) {
                if (!p.containsKey(v.value)) {
                    dist.put(v.value, dist.get(u) + v.weight);
                    p.put(v.value, u);
                    q.enqueue(v.value, dist.get(v.value));
                } else if (dist.get(u) + v.weight < dist.get(v.value)) {
                    dist.put(v.value, dist.get(u) + v.weight);
                    p.put(v.value, u);
                    q.decreaseKey(v.value, dist.get(v.value));
                }
            }
        }

        var path = new ArrayList<Integer>();
        var c = to;
        path.add(c);
        while (p.containsKey(c)) {
            c = p.get(c);
            path.add(0, c);
        }

        return path;
    }
}
