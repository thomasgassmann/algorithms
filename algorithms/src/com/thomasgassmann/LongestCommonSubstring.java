package com.thomasgassmann;

public class LongestCommonSubstring {
    public static int LongestCommonSubstringRecursive(String a, String b) {
        // base case
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }

        var prevA = a.substring(0, a.length() - 1);
        var prevB = b.substring(0, b.length() - 1);
        var deltaMn = a.charAt(a.length() - 1) == b.charAt(b.length() - 1) ? 1 : 0;
        // max of the following three options
        return Math.max(
                LongestCommonSubstringRecursive(prevA, prevB) + deltaMn, // use the previous result (add 1 in case next character is equal)
                Math.max(
                        LongestCommonSubstringRecursive(a, prevB), // ignore one character for sequence b
                        LongestCommonSubstringRecursive(prevA, b) // ignore one character for sequence a
                )
        );
    }
}
