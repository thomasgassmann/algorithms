package com.thomasgassmann.dp;

public class IsShuffle {
    // A&D HS2021
    // Given a char Array A of length n, a char Array B of length m and a char Array C of length n+m
    //
    // Determine if C can be found via a 'straight shuffle' (like putting two decks of cards into one another) of A and B, this basically means that each letter in C can be found in A or B and the internal order of A and B is preserved
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
