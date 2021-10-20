package com.thomasgassmann;

public class QuickSort {
    public static int Partition(int[] a, int left, int right) {
        int i = left - 1;
        int j = right;
        int pivot = a[right];

        do {
            while (++i < right && a[i] < pivot);
            while (--j > left && a[j] > pivot);

            if (i < j) {
                Sorting.Swap(a, i, j);
            }
        } while (i < j);

        Sorting.Swap(a, i, right);
        return i;
    }
}
