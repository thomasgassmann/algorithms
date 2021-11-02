package com.thomasgassmann;

public class LongestCommonSubstring {
    public static int LongestCommonSubstringLength(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];

        int max = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
