package com.thomasgassmann;

import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTests {
    @Test
    public void CheckSequences() {
        var values = new int[][] {
                { 1, 1000, 1001, 2, 3, 4, 5, 999 },
                { 1, 2, 3, 4, 5, 999 }
        };

        for (int i = 0; i < values.length - 1; i += 2) {
            var res = LongestIncreasingSubsequence.LongestIncreasingSubsequence(values[i]);
            AssertionHelpers.AssertEqual(res, values[i + 1]);
        }
    }
}
