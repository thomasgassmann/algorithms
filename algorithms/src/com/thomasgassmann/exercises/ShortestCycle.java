package com.thomasgassmann.exercises;

import java.util.PriorityQueue;

class Graph {
    private int n;              // number of vertices
    private int m;              // number of edges
    private int[] degrees;      // degrees[i]: the degree of vertex i
    private int[][] edges;      // edges[i][j]: the endpoint of the j-th edge of vertex i
    private int[][] weights;    // weights[i][j]: the weight of the j-th edge of vertex i

    Graph(int n, int m, int[][] edgeArray)
    {
        this.n = n;
        this.m = m;
        degrees = new int[n];

        for (int i = 0; i < n; i++) {
            degrees[i]=0;
        }

        for (int i = 0; i < m; i++) {
            degrees[edgeArray[i][0]]++;
            degrees[edgeArray[i][1]]++;
        }

        edges = new int[n][];
        weights = new int[n][];

        for (int i = 0; i < n; i++) {
            if (degrees[i] != 0) {
                edges[i] = new int[degrees[i]];
                weights[i] = new int[degrees[i]];
                degrees[i] = 0;
            } else {
                edges[i] = null;
                weights[i] = null;
            }
        }

        for (int i=0; i<m; i++) {
            edges[edgeArray[i][0]][degrees[edgeArray[i][0]]] = edgeArray[i][1];
            edges[edgeArray[i][1]][degrees[edgeArray[i][1]]] = edgeArray[i][0];
            weights[edgeArray[i][0]][degrees[edgeArray[i][0]]] = edgeArray[i][2];
            weights[edgeArray[i][1]][degrees[edgeArray[i][1]]] = edgeArray[i][2];
            degrees[edgeArray[i][0]]++;
            degrees[edgeArray[i][1]]++;
        }
    }

    public int shortestCycle()
    {
        // Please complete this method.
        // Vertiex v is supposed to be 0.

        // for all edges (0, v) of 0:
        // ignore (0, v): find shortest path to 0
        var q = new PriorityQueue<Pair>();
        int count = 1;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        int[] m = new int[n];
        for (int i = 0; i < degrees[0]; i++) {
            var v = edges[0][i];
            var weight = weights[0][i];
            q.add(new Pair(v, weight));
            d[v] = weight;
            m[v] = count++;
        }

        var min = Integer.MAX_VALUE;
        while (q.size() != 0) {
            var c = q.poll();
            for (int i = 0; i < degrees[c.index]; i++) {
                var w = edges[c.index][i];
                if (w == 0) {
                    continue;
                }

                int weight = weights[c.index][i];
                if (m[w] != m[c.index] && m[w] != 0) {
                    var possibleDistance = d[w] + d[c.index] + weight;
                    if (possibleDistance > 0) {
                        min = Math.min(min, possibleDistance);
                    }

                    continue;
                }

                m[w] = m[c.index];
                int nd = d[c.index] + weight;
                if (d[w] > nd) {
                    d[w] = nd;
                    q.add(new Pair(w, d[w]));
                }
            }
        }

        return min;
    }
}

class Pair implements Comparable<Pair> {
    public int index;
    public int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.value < other.value){
            return -1;
        } else if (this.value == other.value){
            return 0;
        } else {
            return 1;
        }
    }
}