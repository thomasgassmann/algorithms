package com.thomasgassmann;

public class LongestAlternatingSubsequence {
    public static int longest_alternating_subsequence(int n, int []A)
    {
        int incs = 1;
        int decs = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                incs = decs + 1;
            } else if (A[i] < A[i - 1]) {
                decs = incs + 1;
            }
        }

        return Math.max(incs, decs);
    }

    public static int longestAlternatingSubsequenceDP(int[] A) {
        int[][] dp = new int[A.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][0] = Math.max(dp[i][0], Math.max(
                        dp[j][1],
                        A[j] < A[i] ? dp[j][1] + 1 : 0
                ));

                dp[i][1] = Math.max(dp[i][1], Math.max(
                        dp[j][0],
                        A[j] > A[i] ? dp[j][0] + 1 : 0
                ));
            }
        }

        return Math.max(dp[A.length - 1][0], dp[A.length - 1][1]);
    }
}
