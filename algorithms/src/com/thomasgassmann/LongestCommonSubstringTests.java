package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubstringTests {
    @Test
    public void CheckLength() {
        var a = "TIGER";
        var b = "ZIEGE";
        Assertions.assertEquals(
                LongestCommonSubstring.LongestCommonSubstring(a, b),
                "IGE");
        Assertions.assertEquals(
                LongestCommonSubstring.LongestCommonSubstring("PFERD", "RIND"),
                "RD");
        Assertions.assertEquals(
                LongestCommonSubstring.LongestCommonSubstringRecursive(a, b),
                3);
    }
}
