package com.thomasgassmann;

public class MatrixChainMultiplication {
    public static int MostEfficientMatrixAssociativity(int[][][] matrices) {
        int[][] dp = new int[matrices.length][matrices.length];

        // for each col
        for (int p = 0; p < dp.length; p++) {
            // move along diagonal to the lower right
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
                    min = Math.min(dp[currentP][i] + dp[i + 1][currentQ] + cost, min);
                }

                dp[currentP][currentQ] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }

        return dp[0][dp[0].length - 1];
    }
}
