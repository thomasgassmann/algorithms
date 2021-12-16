package com.thomasgassmann.graphs;

public class FloydWarshall {
    public static Integer[][] FloydWarshall(GraphWithWeights<Integer> graph) {
        var n = graph.getVertices().size();
        Integer[][] d = new Integer[n][n];
        for (int i = 0; i < n; i++)
            d[i][i] = 0;

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                d[u][v] = graph.hasEdge(u, v)
                        ? graph.getWeight(u, v)
                        : null;
            }
        }

        Integer[][] succ = new Integer[n][n];
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                succ[u][v] = graph.hasEdge(u, v) ? v : null;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (d[u][i] != null && d[i][v] != null) {
                        var combined = d[u][i] + d[i][v];
                        if (d[u][v] == null || d[u][v] > combined) {
                            d[u][v] = combined;
                            succ[u][v] = succ[u][i];
                        }
                    }
                }
            }
        }

        return succ;
    }
}
