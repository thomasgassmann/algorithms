package com.thomasgassmann.other;

import com.thomasgassmann.sorting.Sorting;

import java.util.Arrays;

public class SelectionProblem {
    // Find k-smallest element in O(n)
    // quick select with median of medians
    public static int selectionProblem(int[] a, int from, int to, int k) {
        if (a.length == 1 && k == 0) {
            return a[k];
        }

        var pivot = partition(a, from, to);
        var rel = pivot - from;
        if (rel == k) {
            return a[pivot];
        } else if (k > rel) {
            return selectionProblem(a, pivot + 1, to, k - rel - 1);
        } else {
            return selectionProblem(a, from, pivot - 1, k);
        }
    }

    private static int partition(int[] a, int from, int to) {
        var pivot = pivot(a, from, to);
        int l = from - 1;
        int r = to + 1;
        int pivotIndex = -1;
        while (r > l) {
            while (a[++l] < pivot);
            while (a[--r] > pivot);
            // keeping track of the pivotIndex is a bit ugly,
            // but it works for now :)
            if (a[l] == pivot)
                pivotIndex = l;
            if (a[r] == pivot)
                pivotIndex = r;

            if (l >= r) {
                if (pivotIndex < l)
                    l = r;
                Sorting.Swap(a, pivotIndex, l);
                return l;
            }

            if (l == pivotIndex)
                pivotIndex = r;
            else if (r == pivotIndex)
                pivotIndex = l;

            Sorting.Swap(a, l, r);
        }

        return -1;
    }

    private static int pivot(int[] a, int from, int to) {
        // see proof in lecture notes why 5 is a good value
        final int MAGIC_GROUP_SIZE = 5;

        int length = (int)Math.ceil((to - from + 1) / 5D);
        int[] r = new int[length];
        int g = 0;
        for (int i = from; i <= to; i += MAGIC_GROUP_SIZE)
            r[g++] = median(a, i, Math.min(i + MAGIC_GROUP_SIZE, to));

        return r.length == 1
            ? r[0]
            : selectionProblem(r, 0, r.length - 1, (int)Math.ceil(length / 2D));
    }

    private static int median(int[] a, int from, int to) {
        if (from == to) {
            return a[from];
        }

        int[] s = Arrays.copyOfRange(a, from, to + 1); // incl.
        Arrays.sort(s);
        return s[(to - from) / 2];
    }
}
