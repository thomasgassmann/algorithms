package com.thomasgassmann.exercises;

public class SubsetSumTriplet {
    public static boolean SubsetSumTriplet(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];
        if (sum % 3 != 0)
            return false;
        int partitionSum = sum / 3;
        boolean[][][] dp = new boolean[values.length + 1][partitionSum + 1][partitionSum + 1];
        dp[0][0][0] = true;
        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j <= partitionSum; j++) {
                for (int k = 0; k <= partitionSum; k++) {
                    dp[i][j][k] = dp[i - 1][j][k] ||
                            (j - values[i - 1] >= 0 && dp[i - 1][j - values[i - 1]][k]) ||
                            (k - values[i - 1] >= 0 && dp[i - 1][j][k - values[i - 1]]);
                }
            }
        }

        return dp[values.length][partitionSum][partitionSum];
    }
}
