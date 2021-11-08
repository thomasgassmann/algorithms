package com.thomasgassmann;

public class GameWithCoins {
    // HS2018 10.4
    public static int GameWithCoins(int[] values) {
        if (values.length % 3 != 0)
            return -1;

        int[][] dp = new int[values.length][values.length / 3 + 1];
        for (int j = 1; j < values.length / 3 + 1; j++) {
            for (int i = 0; i < values.length; i++) {
                dp[i][j] = Math.max(
                        i + 1 < values.length ? dp[i + 1][j - 1] + values[i] : 0,
                        i + 2 < values.length && i + 3 * j - 1 < values.length
                            ? dp[i + 2][j - 1] + values[i + 3 * j - 1]
                            : 0
                );
            }
        }

        return dp[0][values.length / 3];
    }
}
