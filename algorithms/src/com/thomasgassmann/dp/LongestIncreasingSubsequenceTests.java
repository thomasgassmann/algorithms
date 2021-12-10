package com.thomasgassmann.dp;

import com.thomasgassmann.AssertionHelpers;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTests {
    @Test
    public void CheckSequences() {
        var values = new int[][] {
                { 1, 1000, 1001, 2, 3, 4, 5, 999 },
                { 1, 2, 3, 4, 5, 999 },
                { 1, 2, 5, 4, 3 },
                { 1, 2, 3 },
                { 19, 3, 7, 1, 4, 15, 18, 16, 14, 6, 5, 10, 12, 19, 13, 17, 20, 8, 14, 11 },
                { 1, 4, 5, 10, 12, 13, 17, 20 }
        };

        for (int i = 0; i < values.length - 1; i += 2) {
            var res = LongestIncreasingSubsequence.LongestIncreasingSubsequence(values[i]);
            AssertionHelpers.AssertEqual(res, values[i + 1]);

            var resW = LongestIncreasingSubsequence.LongestIncreasingSubsequenceWikipedia(values[i]);
            AssertionHelpers.AssertEqual(resW, values[i + 1]);
        }
    }
}
