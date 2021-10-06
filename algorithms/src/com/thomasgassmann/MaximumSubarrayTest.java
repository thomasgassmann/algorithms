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

    @Test
    public void PrefixSumAlgorithmCalculatesMaximumSubarray() {
        assertEquals(MaximumSubarray.PrefixSums(new int[] {
                7, -11, 15, 110, -23, -3, 127, -12, 1
        }), 226);
    }

    @Test
    public void DivideAndConquerAlgorithmCalculatesMaximumSubarray() {
        int[] values = new int[] {
                7, -11, 15, 110, -23, -3, 127, -12, 1
        };
        assertEquals(MaximumSubarray.DivideAndConquer(values, 0, values.length), 226);
    }
}
