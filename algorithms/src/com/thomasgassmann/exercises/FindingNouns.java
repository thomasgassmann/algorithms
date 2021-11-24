package com.thomasgassmann.exercises;

import java.util.HashMap;

public class FindingNouns {
    public static boolean CanFind(String noSpaces, HashMap<String, Boolean> words) {
        boolean[] dp = new boolean[noSpaces.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= noSpaces.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String current = noSpaces.substring(j, i);
                if (words.containsKey(current) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[noSpaces.length()];
    }
}
