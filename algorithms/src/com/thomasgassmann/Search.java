package com.thomasgassmann;

import java.util.Arrays;

public class Search {
    public static int BinarySearch(int[] a, int b) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (a[middle] == b)
                return middle;
            else if (a[middle] < b)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public static int ExponentialSearch(int[] a, int b) {
        int k = 1;
        while (k < a.length - 1 && b > a[k])
            k *= 2;
        return BinarySearch(Arrays.copyOfRange(a, 0, Math.min(k, a.length - 1)), b);
    }

    public static int InterpolationSearch(int[] a, int b) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            double p = (b - a[left]) / (double)(a[right] - a[left]);
            int middle = left + (int)Math.floor(p * (right - left));
            if (a[middle] == b)
                return middle;
            else if (a[middle] < b)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }
}
