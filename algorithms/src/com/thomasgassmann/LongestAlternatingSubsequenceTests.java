package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestAlternatingSubsequenceTests {
    @Test
    public void checkLongestAlternatingSubsequence() {
        int[] values = new int[] { 1, 9, 2, 3, 5, 4, 6, 7, 8 };

        int longest = LongestAlternatingSubsequence.longest_alternating_subsequence(values.length, values);
        Assertions.assertEquals(6, longest);
    }

    @Test
    public void checkLongestAlternatingSubsequenceDP() {
        int[] values = new int[] { 1, 9, 2, 3, 5, 4, 6, 7, 8 };

        int longest = LongestAlternatingSubsequence.longestAlternatingSubsequenceDP(values);
        Assertions.assertEquals(6, longest);
    }
}
