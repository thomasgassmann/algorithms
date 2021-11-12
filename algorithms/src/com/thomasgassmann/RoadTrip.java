package com.thomasgassmann;

public class RoadTrip {
    public static int possibilities(int[] k, int d) {
        int[] dp = new int[k.length];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int total = 0;
            for (int j = i - 1; k[j] + d >= k[i]; j--) {
                total += dp[j];
            }

            dp[i] = total;
        }

        return dp[k.length - 1];
    }
}
