package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StarducksTests {
    @Test
    public void CheckMaxProfit() {
        int[] distances = new int[] { 1, 2, 6, 7, 8, 9, 10, 15, 20, 25 };
        int[] profits = new int[] { 90, 100, 10, 70, 60, 50, 40, 20, 10, 10 };
        int minDistance = 2;

        int maxProfit = Starducks.MaxProfit(profits, distances, minDistance);
        Assertions.assertEquals(maxProfit, 260);
    }
}
