package com.thomasgassmann;

import org.junit.jupiter.api.Test;

public class HeapSortTests {
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

        SortingTests.AssertEqual(values, expected);
    }
}
