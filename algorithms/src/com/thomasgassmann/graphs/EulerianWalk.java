package com.thomasgassmann.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class EulerianWalk {
    public static ArrayList<Node> EulerianWalk(Graph g) {
        var res = new ArrayList<Node>();
        var markings = new HashMap<Edge, Boolean>();
        EulerWalk(g, g.nodes.get(0), markings, res);
        return res;
    }

    private static void EulerWalk(Graph g, Node node, HashMap<Edge, Boolean> markings, ArrayList<Node> res) {
        for (Edge edge : g.edges.stream().filter(p -> p.from == node || p.to == node).toList()) {
            if (!markings.containsKey(edge)) {
                markings.put(edge, true);
                EulerWalk(g, node == edge.to ? edge.from : edge.to, markings, res);
            }
        }

        res.add(node);
    }
}
