package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTests {
    @Test
    public void CheckPartition() {
        int[] values = new int[] { 56, 3, 100, 6, 2, 84, 8, 4, 74, 8 };
        int res = QuickSort.Partition(values, 0, values.length - 1);
        for (int i = 0; i < res; i++) {
            Assertions.assertTrue(values[res] >= values[i]);
        }

        for (int i = res + 1; i < values.length; i++) {
            Assertions.assertTrue(values[res] <= values[i]);
        }
    }
}
