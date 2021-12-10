package com.thomasgassmann.dp;

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

    public static int[] LongestIncreasingSubsequenceWikipedia(int[] values) {
        int[] p = new int[values.length];
        int[] m = new int[values.length + 1];

        int l = 0;
        for (int i = 0; i < values.length; i++) {
            int lo = 1;
            int hi = l + 1;
            // Binary search for the largest positive j ≤ L
            // such that X[M[j]] < X[i]
            while (lo < hi) {
                int mid = lo + Math.floorDiv(hi - lo, 2);
                if (values[m[mid]] < values[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            // After searching, lo is 1 greater than the
            // length of the longest prefix of X[i]
            int newL = lo;

            // The predecessor of X[i] is the last index of
            // the subsequence of length newL-1
            p[i] = m[newL - 1];
            m[newL] = i;

            // If we found a subsequence longer than any we've
            // found yet, update L
            if (newL > l)
                l = newL;
        }

        // Reconstruct the longest increasing subsequence
        int[] s = new int[l];
        int k = m[l];
        for (int i = l - 1; i >= 0; i--) {
            s[i] = values[k];
            k = p[k];
        }

        return s;
    }
}
