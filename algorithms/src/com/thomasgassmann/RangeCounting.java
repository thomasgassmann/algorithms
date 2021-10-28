package com.thomasgassmann;

public class RangeCounting {
    public static int Range_Counting(int A[], int n, int k_l, int k_r)
    {
        int lowerBound = FindIndex(A, n, k_l);
        int upperBound = FindIndex(A, n, k_r);

        return upperBound - lowerBound;
    }

    private static int FindIndex(int A[], int n, int search) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] < search) {
                l = mid + 1;
            } else if (A[mid] > search) {
                r = mid - 1;
            } else if (A[mid] == search) {
                return mid;
            }
        }

        return l;
    }
}
