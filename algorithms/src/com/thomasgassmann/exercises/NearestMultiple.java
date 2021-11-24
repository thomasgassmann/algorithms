package com.thomasgassmann.exercises;

public class NearestMultiple {
    public static int Nearest_Multiple(int[] A, int n, int p, int k) {
        // A: an array of integers
        // n: size of A
        // p: query position
        // k: query factor

        // The steps within the loop can be considered constant.
        // With this solution we are therefore guaranteed to find
        // the solution in O(|p-q|) steps.
        int step = 0;
        while (p - step >= 1 || p + step <= n) {
            int left = p + -1 * step;
            int right = p + step;

            if (left >= 1 && A[left] % k == 0)
                return left;
            if (right <= n && A[right] % k == 0)
                return right;

            step++;
        }

        // we should never get here, since a solution is guaranteed to exist
        throw new IllegalStateException();
    }
}
