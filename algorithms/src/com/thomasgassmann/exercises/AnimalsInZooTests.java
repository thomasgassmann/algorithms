package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalsInZooTests {
    @Test
    public void checkAnimalsInZoo() {
        int[] weights = new int[] { 1, 2, 3, 2, 3 };
        int[] values = new int[] { 10, 15, 20, 25, 30 };
        int maxWeight = 5;

        Assertions.assertEquals(40, AnimalsInZoo.maxValue(weights, maxWeight, values));
    }
}
