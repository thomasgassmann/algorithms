package com.thomasgassmann.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.thomasgassmann.AssertionHelpers.AssertEqual;

public class QuickSortTests {
    @Test
    public void CheckQuickSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 9, 10, 11, 15, 16, 23 };
        QuickSort.QuickSort(a, 0, a.length - 1);
        AssertEqual(a, r);
    }

    @Test
    public void CheckQuickSortLecture() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 9, 10, 11, 15, 16, 23 };
        QuickSort.QuickSortLecture(a, 0, a.length - 1);
        AssertEqual(a, r);
    }

    @Test
    public void CheckRandomizedQuickSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 9, 10, 11, 15, 16, 23 };
        QuickSort.RandomizedQuickSort(a, 0, a.length - 1);
        AssertEqual(a, r);
    }

    @Test
    public void CheckPartition() {
        int[] values = new int[] { 56, 3, 6, 100, 6, 2, 84, 8, 4, 74, 6, 8 };
        int res = QuickSort.Partition(values, 0, values.length - 1);
        for (int i = 0; i < res; i++) {
            Assertions.assertTrue(values[res] >= values[i]);
        }

        for (int i = res + 1; i < values.length; i++) {
            Assertions.assertTrue(values[res] <= values[i]);
        }
    }
}
