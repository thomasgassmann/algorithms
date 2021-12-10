package com.thomasgassmann.other;

public class Fibonacci {
    public static int FibonacciRecursive(int n) {
        if (n <= 2)
            return 1;
        return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
    }

    public static int FibonacciDynamicProgramming(int n) {
        int[] F = new int[n];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i < n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }

        return F[n - 1];
    }

    public static int FibonacciMemoization(int n, int[] fib) {
        if (fib[n - 1] != 0)
            return fib[n - 1];
        if (n <= 2)
            return 1;
        int nu = FibonacciMemoization(n - 1, fib) + FibonacciMemoization(n - 2, fib);
        fib[n - 1] = nu;
        return nu;
    }
}
