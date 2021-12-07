package com.thomasgassmann.graphs;

public class FloydWarshall {
    public static Integer[][] FloydWarshall(GraphWithWeights<Integer> graph) {
        var n = graph.getVertices().size();
        Integer[][][] d = new Integer[n][n][n];
        for (int i = 0; i < n; i++)
            d[0][i][i] = 0;

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                d[0][u][v] = graph.hasEdge(u, v)
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
                    d[i][u][v] = d[i - 1][u][v];
                    if (d[i - 1][u][i] != null && d[i - 1][i][v] != null) {
                        var combined = d[i - 1][u][i] + d[i - 1][i][v];
                        if (d[i][u][v] == null || d[i][u][v] > combined) {
                            d[i][u][v] = combined;
                            succ[u][v] = succ[u][i];
                        }
                    }
                }
            }
        }

        return succ;
    }
}
