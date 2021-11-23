package com.thomasgassmann.graphs;

import com.thomasgassmann.datastructures.Queue;

import java.util.ArrayList;
import java.util.HashSet;

public class BFS {
    public static ArrayList<Integer> BFS(GraphAdjacencyList graph) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> active = new HashSet<>();
        for (var vertex : graph.getVertices()) {
            BFS(graph, vertex, active, res);
        }

        return res;
    }

    private static void BFS(GraphAdjacencyList graph, int v, HashSet<Integer> active, ArrayList<Integer> res) {
        if (active.contains(v)) {
            return;
        }

        Queue<Integer> q = new Queue<>();

        q.enqueue(v);
        active.add(v);

        while (!q.isEmpty()) {
            int c = q.dequeue();
            res.add(c);
            for (int neighbor : graph.getAdjacent(c)) {
                if (!active.contains(neighbor)) {
                    active.add(neighbor);
                    q.enqueue(neighbor);
                }
            }
        }
    }
}
