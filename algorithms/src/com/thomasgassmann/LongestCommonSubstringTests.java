package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubstringTests {
    @Test
    public void CheckLength() {
        var a = "TIGER";
        var b = "ZIEGE";
        Assertions.assertEquals(
                LongestCommonSubstring.LongestCommonSubstringRecursive(a, b),
                3);
    }
}
