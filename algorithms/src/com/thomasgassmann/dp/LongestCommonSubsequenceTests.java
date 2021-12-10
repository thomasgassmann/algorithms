package com.thomasgassmann.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTests {
    @Test
    public void CheckLength() {
        var a = "TIGER";
        var b = "ZIEGE";
        Assertions.assertEquals(
                LongestCommonSubsequence.LongestCommonSubstring(a, b),
                "IGE");
        Assertions.assertEquals(
                LongestCommonSubsequence.LongestCommonSubstring("PFERD", "RIND"),
                "RD");
        Assertions.assertEquals(
                LongestCommonSubsequence.LongestCommonSubstringRecursive(a, b),
                3);
    }
}
