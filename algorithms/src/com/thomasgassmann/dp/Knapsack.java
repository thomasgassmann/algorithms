package com.thomasgassmann.dp;

import java.util.ArrayList;

public class Knapsack {
    // fully polynomial-time approximation scheme
    public static int[] DPFPTAS(int[] values, int[] weights, int maxWeight, double epsilon) {
        int vmax = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++)
            vmax = Math.max(vmax, values[i]);
        double K = (epsilon * vmax) / values.length;

        int[] av = new int[values.length];
        for (int i = 0; i < av.length; i++)
            av[i] = (int)Math.floor(values[i] / K);

        return DPWeightBased(av, weights, maxWeight);
    }

    public static int[] DPWeightBased(int[] values, int[] weights, int maxWeight) {
        int valsum = 0;
        for (int val : values) valsum += val;
        int[][] dp = new int[values.length + 1][valsum + 1];
        dp[0][0] = 0; // 0 weight for 0 items with 0 value
        for (int v = 1; v < dp[0].length; v++)
            dp[0][v] = maxWeight + 1;

        for (int i = 1; i < dp.length; i++) {
            for (int v = 0; v < dp[0].length; v++) {
                if (v >= values[i - 1]) {
                    dp[i][v] = Math.min(
                            dp[i - 1][v],
                            dp[i - 1][v - values[i - 1]] + weights[i - 1]
                    );
                } else {
                    dp[i][v] = dp[i - 1][v];
                }
            }
        }

        int largestV = 0;
        int largestI = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j > largestV && dp[i][j] <= maxWeight) {
                    largestI = i;
                    largestV = j;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (largestV != 0) {
            if (dp[largestI][largestV] != dp[largestI - 1][largestV]) {
                res.add(largestI - 1);
                largestV -= values[largestI - 1];
            }

            largestI--;
        }

        return res.stream().mapToInt(p -> p).toArray();
    }

    public static int[] DP(int[] values, int[] weights, int maxWeight) {
        int[][] dp = new int[values.length + 1][maxWeight + 1];
        for (int w = 0; w < dp[0].length; w++)
            dp[0][w] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int w = 0; w < dp[0].length; w++) {
                if (w >= weights[i - 1]) {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            dp[i - 1][w - weights[i - 1]] + values[i - 1]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int ci = values.length;
        int cw = maxWeight;
        int max = dp[ci][cw];
        int currentSum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (currentSum != max) {
            if (dp[ci][cw] != dp[ci - 1][cw]) {
                res.add(ci - 1);
                cw -= weights[ci - 1];
                currentSum += values[ci - 1];
            }

            ci--;
        }

        return res.stream().mapToInt(p -> p).toArray();
    }

    public static int[] NaiveDP(int[] values, int[] weights, int maxWeight) {
        int valueSum = 0;
        for (int value : values) valueSum += value;
        boolean[][][] doable = new boolean[values.length + 1][maxWeight + 1][valueSum];

        for (int i = 0; i < doable.length; i++)
            for (int w = 0; w < doable[0].length; w++)
                doable[i][w][0] = true;
        for (int w = 0; w < doable[0].length; w++)
            for (int v = 1; v < doable[0][0].length; v++)
                doable[0][w][v] = false;
        for (int i = 1; i < doable.length; i++) {
            for (int w = 0; w < doable[0].length; w++) {
                for (int v = 1; v < doable[0][0].length; v++) {
                    doable[i][w][v] = doable[i - 1][w][v];
                    if (w >= weights[i - 1] && v >= values[i - 1])
                        doable[i][w][v] |= doable[i - 1][w - weights[i - 1]][v - values[i - 1]];
                }
            }
        }

        int maxi = -1;
        int maxw = -1;
        int maxv = -1;
        for (int v = doable[0][0].length - 1; v >= 0 && maxv < 0; v--) {
            for (int w = 0; w < doable[0].length && maxw < 0; w++) {
                for (int i = 0; i < doable.length; i++) {
                    if (doable[i][w][v]) {
                        maxi = i;
                        maxw = w;
                        maxv = v;
                        break;
                    }
                }
            }
        }

        if (maxi < 0)
            return new int[0];

        ArrayList<Integer> res = new ArrayList<>();
        while (maxi > 0 && maxw >= 0 && maxv >= 0) {
            if (!doable[maxi - 1][maxw][maxv]) {
                res.add(maxi - 1);
                maxw -= weights[maxi - 1];
                maxv -= values[maxi - 1];
            }

            maxi--;
        }

        return res.stream().mapToInt(p -> p).toArray();
    }

    public static int[] Greedy(double[] values, double[] weights, double maxWeight) {
        double[] valueToWeightRatios = new double[values.length];
        for (int i = 0; i < valueToWeightRatios.length; i++)
            valueToWeightRatios[i] = values[i] / weights[i];

        // sort
        for (int i = 0; i < valueToWeightRatios.length; i++) {
            double max = valueToWeightRatios[i];
            int maxIdx = i;
            for (int j = i + 1; j < valueToWeightRatios.length; j++) {
                if (valueToWeightRatios[j] > max) {
                    maxIdx = j;
                    max = valueToWeightRatios[j];
                }
            }

            double tmp = valueToWeightRatios[i];
            valueToWeightRatios[i] = valueToWeightRatios[maxIdx];
            valueToWeightRatios[maxIdx] = tmp;
        }

        ArrayList<Integer> res = new ArrayList<>();
        double cumulativeWeight = 0;
        int c = 0;
        while (cumulativeWeight <= maxWeight) {
            res.add(c);
            cumulativeWeight += weights[c++];
        }

        res.remove(res.size() - 1);
        return res.stream().mapToInt(p -> p).toArray();
    }
}
