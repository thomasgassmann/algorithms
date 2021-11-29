package com.thomasgassmann;

public class LongestAlternatingSubarray {
    public static int longest_alternating_subarray(int n, int[] A) {
        // n: length of A
        // A: an array of distinct integers
        if (n <= 2) {
            // the values are guaranteed to be unique
            return n;
        }

        int currentLength = 1;
        int maxLength = 0;
        boolean greater = A[1] > A[2];
        for (int i = 2; i < n; i++) {
            // in each iteration, we look at A[i], A[i + 1]
            boolean next = A[i] > A[i + 1];

            currentLength = greater == next
                    ? 1
                    : currentLength + 1;

            greater = next;
            if (currentLength > maxLength)
                maxLength = currentLength;
        }

        return maxLength + 1;
    }

    public static int longest_alternating_subarray_solution(int n, int []A)
    {
        // n: length of A
        // A: an array of distinct integers

        int current_length = 0, max_length = 0;
        for (int i = 1; i <= n; i++) {
            if (current_length >= 2 && Math.signum(A[i] - A[i - 1]) * Math.signum(A[i - 1] - A[i - 2]) < 0) {
                current_length += 1;
            } else if (i >= 2) {
                current_length = 2;
            } else {
                current_length = 1;
            }

            if (current_length > max_length) {
                max_length = current_length;
            }
        }

        return max_length;
    }
}
