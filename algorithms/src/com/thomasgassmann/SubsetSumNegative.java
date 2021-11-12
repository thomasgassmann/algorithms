package com.thomasgassmann;

public class SubsetSumNegative {
    public static boolean subsetSumNegative(int[] a, int t) {
        int k = 0;
        int total = 0;
        int lastNegIdx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                k -= a[i];
                lastNegIdx = i;
            }

            total += Math.abs(a[i]);
        }

        boolean[][] dp = new boolean[a.length + 1][total + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = false; // for illustrative purposes
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][k] = true;
            if (i >= lastNegIdx)
                dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= total; j++) {
                int rel = j - a[i - 1];
                dp[i][j] = dp[i - 1][j] || (rel <= total && rel >= 0 && dp[i - 1][rel]);
            }
        }

        return dp[a.length][t + k];
    }
}
