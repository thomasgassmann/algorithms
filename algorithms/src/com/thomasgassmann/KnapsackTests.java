package com.thomasgassmann;

import org.junit.jupiter.api.Test;

public class KnapsackTests {
    @Test
    public void CheckGreedy() {
        double[] weights = new double[] { 1, 2, 3, 4, 5 };
        double[] values = new double[] { 100, 2, 4, 32 };
        double maxWeight = 5;

        int[] choice = Knapsack.Greedy(values, weights, maxWeight);
        AssertionHelpers.AssertEqual(choice, new int[] { 0, 1 });
    }
}
