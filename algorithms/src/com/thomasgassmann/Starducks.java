package com.thomasgassmann;

// exercise 6.5 A&D
public class Starducks {
    public static int MaxProfit(int[] profits, int[] distance, int minDistance) {
        int[] dp = new int[profits.length];
        dp[0] = profits[0];
        for (int i = 1; i < profits.length; i++) {
            int greatestDistance = distance[i] - minDistance;
            int left = 0;
            int right = i;
            int k = -1;
            while (right >= left) {
                int middle = (int)Math.ceil((left + right) / 2);
                if (distance[middle] > greatestDistance) {
                    right = middle - 1;
                } else {
                    k = middle;
                    left = middle + 1;
                }
            }

            dp[i] = Math.max(Math.max(
                    dp[i - 1],
                    profits[i]
            ), k > -1 ? dp[k] + profits[i] : 0);
        }

        return dp[profits.length - 1];
    }
}
