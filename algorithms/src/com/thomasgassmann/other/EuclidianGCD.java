package com.thomasgassmann.other;

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

    public static class ExtendedGCD {
        public ExtendedGCD(int u, int v, int gcd) {
            this.u = u;
            this.v = v;
            this.gcd = gcd;
        }

        public int u;
        public int v;
        public int gcd;
    }

    public static ExtendedGCD ExtendedGCD(int a, int b) {
        int old_r = a;
        int r = b;
        int old_s = 1;
        int s = 0;
        int old_t = 0;
        int t = 1;

        while (r != 0) {
            int quotient = old_r / r;

            int tmpr = r;
            r = old_r - quotient * r;
            old_r = tmpr;

            int tmps = s;
            s = old_s - quotient * s;
            old_s = tmps;

            int tmpt = t;
            t = old_t - quotient * t;
            old_t = tmpt;
        }

        return new ExtendedGCD(old_s, old_t, old_r);
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
