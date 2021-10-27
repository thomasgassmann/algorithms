package com.thomasgassmann;

public class MatrixChainMultiplication {
    public void MostEfficientMatrixAssociativity(int[][][] matrices) {
        int[][] dp = new int[matrices.length][matrices.length];
        for (int i = 0; i < dp.length; i++)
            dp[i][i] = 0;

        for (int p = 0; p < dp.length; p++) {
            for (int q = 0; q < dp.length; q++) {
                int min = Integer.MAX_VALUE;
                for (int i = p; i < q; i++) {
                    // cost of multiplying
                    // (matrices[p] * ... * matrices[i]) * (matrices[i + 1] * matrices[q])
                    int cost = matrices[p - 1].length *
                               matrices[i][0].length *
                               matrices[q][0].length;
                    min = Math.min(dp[p][i] + dp[i + 1][q] + cost, min);
                }

                dp[p][q] = min;
            }
        }

    }
}
