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
}
