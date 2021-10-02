package com.thomasgassmann;

public class Karatsuba {
    public static long multiply(long a, long b) {
        if (a < 10 && b < 10) {
            return a * b;
        }

        long f = Math.max(a, b);
        long s = Math.min(a, b);

        int length = (int)Math.ceil(Math.log10(f));
        int split = length / 2;

        int div = (int)Math.pow(10, split);
        long upperA = f / div;
        long lowerA = f % div;
        long upperB = s / div;
        long lowerB = s % div;

        long upper = Karatsuba.multiply(upperA, upperB);
        long middle = Karatsuba.multiply(upperA + lowerA, upperB + lowerB);
        long lower = Karatsuba.multiply(lowerA, lowerB);

        return upper * (int)Math.pow(div, 2) + (middle - upper - lower) * div + lower;
    }
}
