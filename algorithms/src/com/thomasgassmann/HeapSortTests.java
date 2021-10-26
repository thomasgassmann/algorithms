package com.thomasgassmann;

import org.junit.jupiter.api.Test;

import static com.thomasgassmann.AssertionHelpers.AssertEqual;

public class HeapSortTests {
    @Test
    public void CheckHeapSort() {
        AssertHeapSort(
                new int[] { 3, 6, 5, 1, 2, 4, 8, 7 },
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        AssertHeapSort(
                new int[] { 4, 3, 7, 10, 11, 15, 23, 16, 2, 7, 9, 1, 6 },
                new int[] { 1, 2, 3, 4, 6, 7, 7, 9, 10, 11, 15, 16, 23 });
        AssertHeapSort(
                new int[] { 32, 57, 2, 7 },
                new int[] { 2, 7, 32, 57 });
        AssertHeapSort(
                new int[] { 2, 2, 3, 3, 1, 10, 100 },
                new int[] { 1, 2, 2, 3, 3, 10, 100 });
    }

    public void AssertHeapSort(int[] a, int[] b) {
        HeapSort.HeapSort(a);
        AssertEqual(a, b);
    }

    @Test
    public void RestoreHeapConditionWithLimitedValues() {
        var ar = new int[] { 1, 2, 3 };
        HeapSort.RestoreHeapCondition(
                ar, 0, 2
        );

        AssertEqual(ar, new int[] { 3, 2, 1 });
    }

    @Test
    public void HeapConditionIsRestored() {
        // array has heap condition
        int[] values = new int[] {
                193, 140, 141, 139, 110, 120, 127, 111
        };

        // we remove the top element and replace it with the last
        values[0] = values[values.length - 1];
        values[values.length - 1] = 0;

        // restoring the heap condition, we expect
        int[] expected = new int[] {
                141, 140, 127, 139, 110, 120, 111, 0
        };

        // we updated index 0
        HeapSort.RestoreHeapCondition(values, 0, values.length - 1);

        AssertEqual(values, expected);
    }
}
