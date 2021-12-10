package com.thomasgassmann.dp;

public class LongestCommonSubsequence {
    public static String LongestCommonSubstring(String a, String b) {
        // init dp table
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                var delta = a.charAt(i - 1) == b.charAt(j - 1);
                // same three cases as below
                dp[i][j] = Math.max(
                        dp[i - 1][j - 1] + (delta ? 1 : 0),
                        Math.max(
                                dp[i][j - 1],
                                dp[i - 1][j]
                        )
                );
            }
        }

        // read sequence from dp table
        int ai = a.length();
        int bi = b.length();
        var length = dp[ai][bi];
        var sequence = new StringBuilder();
        while (sequence.length() != length) {
            if (a.charAt(ai - 1) == b.charAt(bi - 1)) {
                // only in this case the length can increase
                // we only need to read an element here
                sequence.append(b.charAt(bi - 1));

                ai--;
                bi--;
            } else if (dp[ai][bi] == dp[ai][bi - 1]) {
                bi--;
            } else {
                ai--;
            }
        }

        // we went through the table in reverse order
        return sequence.reverse().toString();
    }

    public static int LongestCommonSubstringRecursive(String a, String b) {
        // base case
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }

        var prevA = a.substring(0, a.length() - 1);
        var prevB = b.substring(0, b.length() - 1);
        var deltaMn = a.charAt(a.length() - 1) == b.charAt(b.length() - 1) ? 1 : 0;
        // max of the following three options
        return Math.max(
                LongestCommonSubstringRecursive(prevA, prevB) + deltaMn, // use the previous result (add 1 in case next character is equal)
                Math.max(
                        LongestCommonSubstringRecursive(a, prevB), // ignore one character for sequence b
                        LongestCommonSubstringRecursive(prevA, b) // ignore one character for sequence a
                )
        );
    }
}
