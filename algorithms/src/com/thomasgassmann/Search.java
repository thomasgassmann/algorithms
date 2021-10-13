package com.thomasgassmann;

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
