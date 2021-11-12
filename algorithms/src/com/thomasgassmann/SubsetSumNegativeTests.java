package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubsetSumNegativeTests {
    @Test
    public void checkSubsetSumNegative() {
        int[] values = new int[] { -1, -4, 3, 4 };
        Assertions.assertTrue(SubsetSumNegative.subsetSumNegative(values, 7));
        Assertions.assertTrue(SubsetSumNegative.subsetSumNegative(values, -5));
        Assertions.assertTrue(SubsetSumNegative.subsetSumNegative(values, -1));
        Assertions.assertTrue(SubsetSumNegative.subsetSumNegative(values, 2));
        Assertions.assertTrue(SubsetSumNegative.subsetSumNegative(values, 0));
        Assertions.assertFalse(SubsetSumNegative.subsetSumNegative(values, 5));
    }
}
