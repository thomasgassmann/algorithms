package com.thomasgassmann;

public final class PastureBreak {
    private static double log2(double k) {
        return Math.log(k) / Math.log(2);
    }

    private static int f(int i) {
        return (int)Math.pow(2, Math.pow(2, i - 1));
    }

    private static int findNk(int k) {
        int nk = 1;
        while (f(nk) < k) {
            nk++;
        }

        return nk - 1;
    }

    public static int doublyExponentialBest(int k) {
        var summation = k;
        var upperLimit = findNk(k);
        for (int i = 1; i <= upperLimit + 1; i++) {
            summation += 2 * f(i);
        }

        return summation;
    }
}
