package com.thomasgassmann;

// HS2021 7.4
public class AnimalsInZoo {
    public static int maxValue(int[] w, int W, int[] v) {
        int[][] dp = new int[v.length + 1][W + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {
                int offset = i <= 3 ? 1 : 4;
                int weightIdx = j - w[i - 1];
                dp[i][j] = Math.max(
                        dp[i - 1][j],
                        weightIdx >= 0 && weightIdx <= W
                                ? dp[i - offset][weightIdx] + v[i - 1]
                                : 0
                );
            }
        }

        return dp[v.length][W];
    }
}
