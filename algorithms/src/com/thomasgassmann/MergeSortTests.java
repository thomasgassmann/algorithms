package com.thomasgassmann;

import org.junit.jupiter.api.Test;

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

        SortingTests.AssertEqual(a, res);
    }
}
