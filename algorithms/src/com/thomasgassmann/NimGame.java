package com.thomasgassmann;

public class NimGame {
    // HS2019 8.4
    public static boolean NimGame(int n1, int n2) {
        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[0][0] = 0; // next player does not win
        for (int j = 0; j <= n2; j++) {
            for (int i = 0; i <= n1; i++) {
                if ((KExists(dp, i, j, true) || KExists(dp, j, i, false)) && (i != 0 || j != 0)) {
                    dp[i][j] = 1;
                }
            }
        }

        return dp[n1][n2] == 1;
    }

    private static boolean KExists(int[][] dp, int bound, int staticv, boolean firstDimension) {
        for (int k = 1; k <= Math.sqrt(bound); k++) {
            int power = (int)Math.pow(k, 2);
            if ((firstDimension && dp[bound - power][staticv] == 0) ||
                (!firstDimension && dp[staticv][bound - power] == 0)) {
                return true;
            }
        }

        return false;
    }
}
