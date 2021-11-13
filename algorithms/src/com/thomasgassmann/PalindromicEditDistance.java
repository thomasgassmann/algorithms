package com.thomasgassmann;

public class PalindromicEditDistance {
    public static int Palindromic_Edit_Distance(char []A)
    {
        int n = A.length;

        //  A:      The input sequence
        //  n:      The length of A;

        int[][] dp =new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int ci = j;
                int cj = i + j;
                dp[ci][cj] = Math.min(
                        Math.min(
                                A[ci] == A[cj] ? dp[ci + 1][cj - 1] : Integer.MAX_VALUE,
                                dp[ci][cj - 1] + 1
                        ),
                        Math.min(
                                dp[ci + 1][cj] + 1,
                                dp[ci + 1][cj - 1] + 1
                        )
                );
            }
        }

        return dp[0][n-1];
    }
}
