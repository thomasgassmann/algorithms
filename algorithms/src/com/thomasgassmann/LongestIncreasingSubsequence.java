package com.thomasgassmann;

public class LongestIncreasingSubsequence {
    public static int[] LongestIncreasingSubsequence(int[] values) {
        // stores last value of longest increasing subsequence for length l
        int[] T = new int[values.length + 1];
        // stores previous elements
        int[] V = new int[values.length];

        T[0] = Integer.MIN_VALUE;
        for (int i = 1; i < T.length; i++)
            T[i] = Integer.MAX_VALUE;

        for (int i = 0; i < values.length; i++) {
            // binary search a value such that
            // T[l] < values[i] < T[l + 1]
            // we then append values[i] to T[l] to form a new subsequence
            int l = 0;
            int r = T.length - 1;
            while (l <= r) {
                int middle = Math.floorDiv(l + r, 2);
                if (T[middle] < values[i] && values[i] < T[middle + 1]) {
                    l = middle;
                    break;
                }

                if (T[middle] > values[i])
                    r = middle;
                if (T[middle] < values[i])
                    l = middle;
            }

            // subsequence with l + 1 length, ending with values[i]
            T[l + 1] = values[i];
            // storing the previous element
            V[i] = T[l];
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = T.length - 1; i >= 0; i--) {
            if (T[i] < Integer.MAX_VALUE) {
                maxLength = i;
                break;
            }
        }

        // reconstruct sequence
        int[] res = new int[maxLength];
        res[maxLength - 1] = T[maxLength];
        int i = values.length - 1;
        int resPointer = maxLength - 1;
        int search = T[maxLength];
        while (resPointer > 0) {
            while (values[i] != search)
                i--;
            res[--resPointer] = V[i];
            search = V[i];
        }

        return res;
    }
}
