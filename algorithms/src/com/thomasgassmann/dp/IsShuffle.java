package com.thomasgassmann.dp;

public class IsShuffle {
    // Probe Test A&D HS2021
    public static boolean isShuffle(int n, int m, char[] A, char[] B, char[] C)
    {
        //The input arrays A, B and C are indexed from 1 instead of 0 in the code.

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        dp[0][1] = C[1] == B[1];
        dp[1][0] = C[1] == A[1];

        for (int j = 2; j < m + 1; j++) {
            dp[0][j] = dp[0][j - 1] && C[j] == B[j];
        }

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] && C[i] == A[i];
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = (dp[i][j - 1] && B[j] == C[i + j]) || (dp[i - 1][j] && A[i] == C[i + j]);
            }
        }

        return dp[n][m];
    }
}
