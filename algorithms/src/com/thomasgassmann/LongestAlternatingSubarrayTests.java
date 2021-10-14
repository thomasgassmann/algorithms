package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestAlternatingSubarrayTests {
    @Test
    public void LongestSubarrayLengthReturned() {
        var array = new int[] {
                0,
                1,
                9,
                2,
                3,
                5,
                4,
                6,
                7,
                8
        };
        Assertions.assertEquals(
                LongestAlternatingSubarray.longest_alternating_subarray(array.length - 1, array), 4);
    }
}
