package com.thomasgassmann.other;

public class IterativeSquaring {
    // power should be n = 2^k
    public static int SquareEvenPower(int a, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return a;
        return SquareEvenPower(a * a, n / 2);
    }

    public static int SquarePower(int a, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return a;
        if (n % 2 == 0)
            return SquarePower(a * a, n / 2);
        return a * SquarePower(a * a, (n - 1) / 2);
    }
}
