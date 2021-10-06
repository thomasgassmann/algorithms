package com.thomasgassmann;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTest {
    @Test
    public void NaiveAlgorithmCalculatesMaximumSubarray() {
        assertEquals(MaximumSubarray.Naive(new int[] {
                7, -11, 15, 110, -23, -3, 127, -12, 1
        }), 226);
    }
}
