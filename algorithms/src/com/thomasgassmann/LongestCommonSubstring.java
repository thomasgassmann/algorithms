package com.thomasgassmann;

public class LongestCommonSubstring {
    public static int LongestCommonSubstringRecursive(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }

        var prevA = a.substring(0, a.length() - 1);
        var prevB = b.substring(0, b.length() - 1);
        var deltaMn = a.charAt(a.length() - 1) == b.charAt(b.length() - 1) ? 1 : 0;
        return Math.max(
                LongestCommonSubstringRecursive(prevA, prevB) + deltaMn,
                Math.max(
                        LongestCommonSubstringRecursive(a, prevB),
                        LongestCommonSubstringRecursive(prevA, b)
                )
        );
    }
}
