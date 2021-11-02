package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubstringTests {
    @Test
    public void CheckLongestCommonSubstring() {
        Assertions.assertEquals(
                LongestCommonSubstring.LongestCommonSubstringLength("abc", "cab"), 2);
    }
}
