package com.thomasgassmann;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubmatrixSumTests {
    @Test
    public void SubmatrixSumCorrect() {
        assertEquals(MaximumSubmatrixSum.MaximumSubmatrixSum(new int[][] {
                { -7, -1, -1, -1 },
                { -5, -1, 4, 4},
                { -2, 6, 4, 4 },
                { 2, 5, -3, 8}
        }), 31);
    }
}
