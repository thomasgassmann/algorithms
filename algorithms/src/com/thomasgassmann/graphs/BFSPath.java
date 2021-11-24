package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.Queue;

import java.util.ArrayList;
import java.util.HashMap;

public class BFSPath {
    public static ArrayList<Node> BFSPath(Graph graph, Node s, Node t) {
        var p = new HashMap<Node, Node>();
        var q = new Queue<Node>();
        q.enqueue(s);
        while (!q.isEmpty()) {
            var u = q.dequeue();
            for (var v : graph.getAdjacent(u)) {
                if (!p.containsKey(v)) {
                    p.put(v, u);
                    q.enqueue(v);
                }
            }
        }

        var path = new ArrayList<Node>();
        var v = t;
        while (v != s) {
            path.add(0, v);
            v = p.get(v);
        }

        path.add(0, v);
        return path;
    }
}
