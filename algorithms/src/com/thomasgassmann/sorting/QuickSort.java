package com.thomasgassmann.sorting;

import java.util.Random;

public class QuickSort {
    public static void QuickSort(int[] a, int l, int r) {
        if (l >= 0 && r >= 0 && l < r) {
            int k = Partition(a, l, r);
            QuickSort(a, l, k);
            QuickSort(a, k + 1, r);
        }
    }

    public static void RandomizedQuickSort(int[] a, int l, int r) {
        if (l >= 0 && r >= 0 && l < r) {
            int k = RandomizedPartition(a, l, r);
            QuickSort(a, l, k);
            QuickSort(a, k + 1, r);
        }
    }

    public static int RandomizedPartition(int[] a, int left, int right) {
        var random = new Random();
        var pos = random.nextInt(right - left + 1) + left;
        Sorting.Swap(a, pos, a[right]);
        return PartitionLecture(a, left, right);
    }

    public static int Partition(int[] a, int left, int right) {
        int pivot = a[Math.floorDiv(left + right, 2)];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            while (a[++i] < pivot);
            while (a[--j] > pivot);

            if (i >= j)
                return j;

            Sorting.Swap(a, i, j);
        }
    }

    public static void QuickSortLecture(int[] a, int left, int right) {
        if (left < right) {
            int k = PartitionLecture(a, left, right);
            QuickSort(a, left, k - 1);
            QuickSort(a, k + 1, right);
        }
    }

    public static int PartitionLecture(int[] a, int l, int r) {
        int i = l;
        int j = r - 1;
        int p = a[r];
        do {
            while (i < r && a[i] < p)
                i++;
            while (j > l && a[j] > p)
                j--;
            if (i < j)
                Sorting.Swap(a, i, j);
        } while (i < j);
        Sorting.Swap(a, i, r);
        return i;
    }
}
