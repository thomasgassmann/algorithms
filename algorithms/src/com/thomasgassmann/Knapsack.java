package com.thomasgassmann;

import java.util.ArrayList;

public class Knapsack {
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
