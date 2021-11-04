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

    @Test
    public void CheckNaiveDP() {
        int[] weights = new int[] { 1, 2, 3, 4, 5 };
        int[] values = new int[] { 100, 2, 4, 32, 2 };
        int maxWeight = 5;

        int[] choice = Knapsack.NaiveDP(values, weights, maxWeight);
        AssertionHelpers.AssertEqual(choice, new int[] { 3, 0 });
    }

    @Test
    public void CheckDP() {
        int[] weights = new int[] { 1, 2, 3, 4, 5 };
        int[] values = new int[] { 100, 2, 4, 32, 2 };
        int maxWeight = 5;

        int[] choice = Knapsack.DP(values, weights, maxWeight);
        AssertionHelpers.AssertEqual(choice, new int[] { 3, 0 });
    }

    @Test
    public void CheckDPWeightBased() {
        int[] weights = new int[] { 1, 2, 3, 4, 5 };
        int[] values = new int[] { 100, 2, 4, 32, 2 };
        int maxWeight = 5;

        int[] choice = Knapsack.DPWeightBased(values, weights, maxWeight);
        AssertionHelpers.AssertEqual(choice, new int[] { 3, 0 });
    }
}
