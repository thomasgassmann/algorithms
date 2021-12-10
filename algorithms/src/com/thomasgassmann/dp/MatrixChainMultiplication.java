package com.thomasgassmann.dp;

import java.util.ArrayList;

public class MatrixChainMultiplication {
    public static class Associativity {
        private int _from;
        private int _to;

        public Associativity(int from, int to) {
            _from = from;
            _to = to;
        }

        public int from() {
            return _from;
        }

        public int to() {
            return _to;
        }
    }

    public ArrayList<Associativity> MostEfficientMatrixAssociativity(int[][][] matrices) {
        int[][] dp = new int[matrices.length][matrices.length];

        var assoc = new ArrayList<Associativity>();

        // for each col
        for (int p = 0; p < dp.length; p++) {
            // move along diagonal to the lower right
            int minP = Integer.MAX_VALUE;
            int minQ = Integer.MAX_VALUE;
            int diagonalMin = Integer.MAX_VALUE;
            for (int q = 0; q < dp.length - p; q++) {
                int currentQ = p + q;
                int currentP = q;

                int min = Integer.MAX_VALUE;
                for (int i = currentP; i < currentQ; i++) {
                    // cost of multiplying
                    // (matrices[p] * ... * matrices[i]) * (matrices[i + 1] * matrices[q])
                    int cost = matrices[currentP].length *
                               matrices[i][0].length *
                               matrices[currentQ][0].length;
                    int total = dp[currentP][i] + dp[i + 1][currentQ] + cost;
                    if (total < min) {
                        min = total;
                    }
                }

                dp[currentP][currentQ] = min == Integer.MAX_VALUE ? 0 : min;
                if (min < diagonalMin) {
                    diagonalMin = min;
                    minP = currentP;
                    minQ = currentQ;
                }
            }

            if (p != 0) {
                assoc.add(new Associativity(minP, minQ));
            }
        }

        return assoc;
    }
}
