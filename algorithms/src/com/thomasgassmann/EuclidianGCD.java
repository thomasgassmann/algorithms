package com.thomasgassmann;

public class EuclidianGCD {
    public static long GCDIterative(long n, long m) {
        if (m > n) {
            long tmp = n;
            n = m;
            m = tmp;
        }

        while (m > 0) {
            long r = n % m;
            n = m;
            m = r;
        }

        return n;
    }

    public static long GCD(long n, long m) {
        if (m > n) {
            long tmp = m;
            m = n;
            n = tmp;
        }

        if (m == 0) {
            return n;
        }

        return GCD(m, n % m);
    }
}
