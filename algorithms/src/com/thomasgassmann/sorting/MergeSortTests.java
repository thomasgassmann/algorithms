package com.thomasgassmann.sorting;

import org.junit.jupiter.api.Test;

import static com.thomasgassmann.AssertionHelpers.AssertEqual;

public class MergeSortTests {
    @Test
    public void CheckMergeArray() {
        int[] a = new int[] {
                1, 2, 3, 4, 2, 3, 4, 5, 6
        };
        int[] res = new int[] {
                1, 2, 2, 3, 3, 4, 4, 5, 6
        };
        MergeSort.Merge(a, 0, 3, a.length - 1);

        AssertEqual(a, res);
    }

    @Test
    public void CheckMergeSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9, 10, 11, 15, 16, 23 };
        MergeSort.MergeSort(a, 0, a.length - 1);
        AssertEqual(a, r);
    }

    @Test
    public void CheckStraightMergeSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9, 10, 11, 15, 16, 23 };
        MergeSort.StraightMergeSort(a);
        AssertEqual(a, r);
    }

    @Test
    public void CheckNaturalMergeSort() {
        int[] a = new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 7, 9, 1 };
        int[] r = new int[] { 1, 2, 3, 4, 7, 7, 9, 10, 11, 15, 16, 23 };
        MergeSort.NaturalMergeSort(a);
        AssertEqual(a, r);
    }
}
