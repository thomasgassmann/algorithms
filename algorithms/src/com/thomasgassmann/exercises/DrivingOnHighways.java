package com.thomasgassmann.exercises;

import com.thomasgassmann.graphs.Graph;
import com.thomasgassmann.graphs.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class DrivingOnHighways {
    public static boolean DrivingOnHighways(Graph graph) {
        if (graph.vertices.size() == 0) {
            return true;
        }

        var markings = new HashSet<Node>();
        var reachable = new HashMap<Node, Boolean>();
        var random = new Random();
        var idx = random.nextInt(graph.vertices.size());
        var u = graph.vertices.get(idx);
        markings.add(u);
        reachable.put(u, true);
        DFSVisit(graph, u, markings, reachable);
        if (markings.size() != graph.vertices.size()) {
            return false;
        }

        for (var key : reachable.keySet()) {
            if (!reachable.get(key)) {
                return false;
            }
        }

        return true;
    }

    private static void DFSVisit(
            Graph graph,
            Node u,
            HashSet<Node> markings,
            HashMap<Node, Boolean> reachable) {
        if (graph.getAdjacent(u).size() == 0) {
            reachable.put(u, false);
            return;
        }

        for (var adj : graph.getAdjacent(u)) {
            if (reachable.getOrDefault(adj, false)) {
                reachable.put(u, true);
                break;
            }
        }

        markings.add(u);
        var canReachRoot = false;
        for (var adj : graph.getAdjacent(u)) {
            if (!markings.contains(adj)) {
                DFSVisit(graph, adj, markings, reachable);
                canReachRoot |= reachable.get(adj);
            }
        }

        if (!reachable.containsKey(u)) {
            reachable.put(u, canReachRoot);
        }
    }
}
